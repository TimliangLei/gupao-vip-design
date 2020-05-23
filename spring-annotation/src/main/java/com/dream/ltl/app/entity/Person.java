package com.dream.ltl.app.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Person {
    private String name;
    private int age;

}
