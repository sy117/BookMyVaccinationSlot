package com.sklearns.vaccinationslotnotifier.scheduler;

import com.sklearns.vaccinationslotnotifier.dto.Session;
import com.sklearns.vaccinationslotnotifier.service.EmailSenderService;
import com.sklearns.vaccinationslotnotifier.service.VaccineFinderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CronScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(CronScheduler.class);

    @Autowired
    private VaccineFinderService vaccineFinderService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Value("${spring.mail.username}")
    private String email;

    @Value("${pincode:811308}")
    private Integer pinCode;

    @Value("${age:20}")
    private Integer age;

    // Checking Vaccine Availability in every 4 hr
    @Scheduled(fixedDelay = 1000 * 60 * 60 * 4, initialDelay = 1000 * 60)
    public void fixedDelaySch(){
        LOG.info("Executing Scheduled method at: {}", LocalDateTime.now());

        try{
            List<Session> centers = vaccineFinderService.getVaccineAvailabilityByPinCodeAndAge(pinCode, age);

            if(centers.size() > 0){
                String mailBody = "Hi," + "\n" + "Please find Details of centers where Vaccine is currently available. \n" + centers.toString();
                LOG.info("Sending Vaccine Availability details to: {}", email);
                emailSenderService.sendEmail(email, "Vaccine Available Alert!", mailBody);
            }
        }
        catch (Exception ex){
            LOG.error("", ex);
        }
    }
}
