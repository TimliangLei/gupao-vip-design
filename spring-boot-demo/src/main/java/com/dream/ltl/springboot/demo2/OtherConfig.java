package com.dream.ltl.springboot.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class OtherConfig {
    @Conditional(DefindCondition.class)
    @Bean
    public OtherClass getOtherClass(){
        return new OtherClass();
    }
}
