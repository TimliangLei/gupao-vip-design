package com.dream.ltl.springboot.startDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class TestAutoConfiguration {
    @Bean
    public Service getBean(){
        return new Service();
    }
}
