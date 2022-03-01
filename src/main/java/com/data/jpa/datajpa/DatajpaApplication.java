package com.data.jpa.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class DatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatajpaApplication.class, args);
    }

}
