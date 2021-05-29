package com.ngnam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
    exclude = SecurityAutoConfiguration.class,
    scanBasePackages = "com.ngnam"
)
public class Project1MpecApplication {
    public static void main(String[] args) {
        SpringApplication.run(Project1MpecApplication.class, args);
    }
}
