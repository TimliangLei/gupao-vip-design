package com.dream.ltl.pattern.bridge;

import com.dream.ltl.pattern.bridge.course.ICourse;
import com.dream.ltl.pattern.bridge.note.INote;
import com.dream.ltl.pattern.bridge.video.IVideo;

public abstract class AbstractCourse implements ICourse {
    private INote iNote;
    private IVideo iVideo;

    public void setiNote(INote iNote) {
        this.iNote = iNote;
    }

    public void setiVideo(IVideo iVideo) {
        this.iVideo = iVideo;
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "iNote=" + iNote +
                ", iVideo=" + iVideo +
                '}';
    }
}
