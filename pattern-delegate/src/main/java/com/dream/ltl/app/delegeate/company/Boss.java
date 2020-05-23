package com.dream.ltl.app.delegeate.company;

public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
