package com.dream.ltl.pattern.bridge.course;

import com.dream.ltl.pattern.bridge.AbstractCourse;
import com.dream.ltl.pattern.bridge.note.JavaNote;
import com.dream.ltl.pattern.bridge.video.JavaVideo;

public class JavaCourse extends AbstractCourse {
    public JavaCourse() {
        super.setiNote(new JavaNote());
        super.setiVideo(new JavaVideo());
    }
}
