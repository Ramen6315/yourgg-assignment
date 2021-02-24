package com.yourgg.assignment.config;

import org.springframework.context.annotation.Bean;

import feign.Retryer;

public class FeignRetryConfiguration {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }
}