package org.sleepless_artery.enrollment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EnrollmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrollmentServiceApplication.class, args);
    }

}
