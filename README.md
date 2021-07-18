# BookMyVaccinationSlot
This is a Spring Boot Application which tracks availability of vaccine using pincode as a scheduled task(cron job) and notifies user over email.
 - Takes User Email, Age and Pincode as input parameters in config
 - Executes scheduled method after a regular interval of 4 hr (configurable)
 - Checks Availability of vaccine for current date
 - Sends user an email containing details of centers

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Maven
Java8
Spring
```

### Installing

Follow these steps to installing  dependencies and running this project on your local
by setting development environment:

- Clone project on local

```
 https://github.com/sy117/BookMyVaccinationSlot.git
```

- Open project in Intellij Idea IDE
```

```
- Set environment variables in application.properties file

```
spring.mail.username=<YOUR_EMAIL>
spring.mail.password=<PASSWORD>
pincode=<PINCODE>
age=<AGE>
```

- Run project from IDE

```
 click on run button
```

## Deployment

Add deployment steps by yourself.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency manager

## Improvements

* In the current implementation the email sent contain list of centers where vaccine is available on that day
* For some cities this list can be very large and the email body will look messy
* As an improvement, we can write center details to a Google Sheet using Sheet API
* In the email body we can send the url of spreadsheet to user