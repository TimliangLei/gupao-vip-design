package com.dream.ltl.spring.annotation.lazy;

import com.dream.ltl.app.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyConfig {

//    默认首字母小写-方法名
//    最后优先取@Bean("***")
//    @Lazy
    @Bean
    public Person person(){
        System.out.println("将对象添加到ioc容器中");
        return  new Person("Tom",8);
    }
}
