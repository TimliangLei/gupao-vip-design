package com.dream.ltl.app.template;

public class JavaCourse extends AbstractCourse {

    private boolean needCheck = false;

    public void setNeedCheck(boolean needCheck) {
        this.needCheck = needCheck;
    }

    @Override
    protected boolean needCheckHomeWork() {
        return this.needCheck;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("检查Java作业");
    }
}
