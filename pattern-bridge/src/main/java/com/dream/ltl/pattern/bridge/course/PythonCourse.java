package com.dream.ltl.pattern.bridge.course;

import com.dream.ltl.pattern.bridge.AbstractCourse;
import com.dream.ltl.pattern.bridge.note.PythonNote;
import com.dream.ltl.pattern.bridge.video.PythonVideo;

public class PythonCourse extends AbstractCourse {
    public PythonCourse() {
        super.setiNote(new PythonNote());
        super.setiVideo(new PythonVideo());
    }
}
