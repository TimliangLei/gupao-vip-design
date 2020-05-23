package com.dream.ltl.app.springboot.javaBeandemo1;

import com.dream.ltl.app.springboot.javaBeandemo2.OtherClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        OtherClass otherClass = context.getBean(OtherClass.class);
        otherClass.say();
        System.out.println(helloService.say());
    }

}
