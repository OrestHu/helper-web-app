package com.horuz.test.helpwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class HelpWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpWebAppApplication.class, args);
    }

}
