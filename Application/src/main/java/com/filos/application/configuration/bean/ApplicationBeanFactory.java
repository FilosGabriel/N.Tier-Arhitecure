package com.filos.application.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ApplicationBeanFactory {

    @Bean
    public Clock instantiateClock() {
        return Clock.systemUTC();
    }
}
