package com.example.productservice.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //At the time of application opening, Spring will go through all the special classes
    // and create the Bean in this case
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplateBuilder().build();

    }

}
