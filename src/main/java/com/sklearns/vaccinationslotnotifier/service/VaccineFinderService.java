package com.sklearns.vaccinationslotnotifier.service;

import com.sklearns.vaccinationslotnotifier.dto.Session;
import com.sklearns.vaccinationslotnotifier.dto.Sessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VaccineFinderService {
    private static final Logger LOG = LoggerFactory.getLogger(VaccineFinderService.class);

    @Autowired
    private RestTemplate restTemplate;
    private final String BASE_URL = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?";

    public List<Session> getVaccineAvailabilityByPinCodeAndAge(Integer pinCode, Integer age){
        LocalDateTime currentDateTime = LocalDateTime.now();
        String date = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fullUrl = BASE_URL + "pincode=" + pinCode + "&date=" + date;
        LOG.info("Fetching Vaccine Availability for {} ", currentDateTime);
        Sessions sessions = restTemplate.getForObject(fullUrl, Sessions.class);

        List<Session> validSessions = sessions.getSessions()
                .stream()
                .filter(session -> session.getAvailableCapacity() > 0 && (session.getMinAgeLimit() <= age || session.getAllowAllAge()))
                .collect(Collectors.toList());

        LOG.info("Number of Valid Vaccination Center: {} ", validSessions.size());
        return validSessions;

    }
}
