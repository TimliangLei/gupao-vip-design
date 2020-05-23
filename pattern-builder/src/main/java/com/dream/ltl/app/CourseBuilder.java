package com.dream.ltl.app;

public class CourseBuilder {

    private Course course = new Course();

    public String build(){
        return  course.toString();
    }

    public CourseBuilder addName (String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addPPT (String ppt){
        course.setPpt(ppt);
        return this;
    }
    public CourseBuilder addVideo (String video){
        course.setVideo(video);
        return this;
    }
    public CourseBuilder addNote (String note){
        course.setNote(note);
        return this;
    }
}
