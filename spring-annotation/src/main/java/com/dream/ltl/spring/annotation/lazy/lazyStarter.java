package com.dream.ltl.spring.annotation.lazy;

import com.dream.ltl.app.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class lazyStarter {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成");
        Object o = app.getBean(Person.class);
        System.out.println(o);
    }
}
