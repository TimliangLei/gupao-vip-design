package com.dream.ltl.app.pattern.bridge.course;

import com.dream.ltl.app.pattern.bridge.AbstractCourse;
import com.dream.ltl.app.pattern.bridge.note.JavaNote;
import com.dream.ltl.app.pattern.bridge.video.JavaVideo;

public class JavaCourse extends AbstractCourse {
    public JavaCourse() {
        super.setiNote(new JavaNote());
        super.setiVideo(new JavaVideo());
    }
}
