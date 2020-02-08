package com.mcb.creditfactory.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Конфигурация тестирования для REST-сервиса
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mcb.creditfactory"})
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}