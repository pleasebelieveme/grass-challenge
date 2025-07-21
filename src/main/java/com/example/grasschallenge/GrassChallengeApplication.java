package com.example.grasschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrassChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrassChallengeApplication.class, args);
    }

}
