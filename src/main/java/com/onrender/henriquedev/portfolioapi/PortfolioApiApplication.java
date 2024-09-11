package com.onrender.henriquedev.portfolioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PortfolioApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApiApplication.class, args);
    }

}
