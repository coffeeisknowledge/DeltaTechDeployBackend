package com.deltatech.diligencetech.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DiligenceTechPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiligenceTechPlatformApplication.class, args);
    }

}
