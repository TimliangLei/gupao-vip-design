package com.dream.ltl.springboot.javaBeandemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class OtherConfig {
    @Conditional(DefindCondition.class)//加载bean
    @Bean
    public OtherClass getOtherClass(){
        return new OtherClass();
    }
}
