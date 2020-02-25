package com.dream.ltl.springboot.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public HelloService helloService(){
        return  new HelloService();
    }
}
