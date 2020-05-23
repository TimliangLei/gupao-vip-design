package com.dream.ltl.app.springboot.javaBeandemo1;

import com.dream.ltl.app.springboot.javaBeandemo2.OtherConfig;
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
