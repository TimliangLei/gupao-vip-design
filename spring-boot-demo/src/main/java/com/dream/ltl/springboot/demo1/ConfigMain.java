package com.dream.ltl.springboot.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.say());
    }

}
