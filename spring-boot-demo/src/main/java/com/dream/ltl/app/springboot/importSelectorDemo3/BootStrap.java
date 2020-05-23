package com.dream.ltl.app.springboot.importSelectorDemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDefineService
@SpringBootApplication
public class BootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(BootStrap.class,args);
        TestService testService = context.getBean(TestService.class);
        testService.say();
    }
}
