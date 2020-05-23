package com.dream.ltl.spring.annotation.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ComponentScanApp {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        String[] beanNames = app.getBeanDefinitionNames();
        System.out.println(
                Arrays.toString(beanNames)
                        .replaceAll("\\[|\\]","")
                        .replaceAll(",","\n"));
    }
}
