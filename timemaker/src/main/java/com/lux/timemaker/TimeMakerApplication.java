package com.lux.timemaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TimeMakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeMakerApplication.class, args);
    }

}
