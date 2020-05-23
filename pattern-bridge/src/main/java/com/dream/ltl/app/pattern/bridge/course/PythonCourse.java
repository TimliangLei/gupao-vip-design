package com.dream.ltl.app.pattern.bridge.course;

import com.dream.ltl.app.pattern.bridge.AbstractCourse;
import com.dream.ltl.app.pattern.bridge.note.PythonNote;
import com.dream.ltl.app.pattern.bridge.video.PythonVideo;

public class PythonCourse extends AbstractCourse {
    public PythonCourse() {
        super.setiNote(new PythonNote());
        super.setiVideo(new PythonVideo());
    }
}
