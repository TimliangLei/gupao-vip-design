package com.dream.ltl.springboot.demo1;

import com.dream.ltl.springboot.demo2.OtherClass;
import com.dream.ltl.springboot.demo2.OtherConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(OtherConfig.class)
public class SpringConfig {

    @Bean
    public HelloService helloService(){
        return  new HelloService();
    }
}
