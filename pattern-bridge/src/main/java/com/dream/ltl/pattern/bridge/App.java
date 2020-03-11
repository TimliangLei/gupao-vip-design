package com.dream.ltl.pattern.bridge;

import com.dream.ltl.pattern.bridge.course.JavaCourse;
import com.dream.ltl.pattern.bridge.note.JavaNote;

public class App {
    public static void main(String[] args) {
        AbstractCourse course = new JavaCourse();

        System.out.println(course);
    }
}
