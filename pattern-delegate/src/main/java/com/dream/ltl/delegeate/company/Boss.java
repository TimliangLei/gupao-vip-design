package com.dream.ltl.delegeate.company;

public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
