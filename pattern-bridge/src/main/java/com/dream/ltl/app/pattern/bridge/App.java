package com.dream.ltl.app.pattern.bridge;

import com.dream.ltl.app.pattern.bridge.course.JavaCourse;

public class App {
    public static void main(String[] args) {
        AbstractCourse course = new JavaCourse();

        System.out.println(course);
    }
}
