package com.dream.ltl.app.iterator;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
