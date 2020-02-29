package com.dream.ltl;

public class Simple {
    public static void main(String[] args) {


        CourseBuilder builder = new CourseBuilder();

        builder.addName("ltl")
                .addPPT("ppt")
                .addNote("note")
                .addVideo("video");

        System.out.println(builder.build());
    }
}
