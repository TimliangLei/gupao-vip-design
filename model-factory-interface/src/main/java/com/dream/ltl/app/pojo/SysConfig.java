package com.dream.ltl.app.pojo;

public class SysConfig {
    private String checkClassPath;
    private String payClassPath;

    public SysConfig(String checkClassPath, String payClassPath) {
        this.checkClassPath = checkClassPath;
        this.payClassPath = payClassPath;
    }

    public String getCheckClassPath() {
        return checkClassPath;
    }

    public void setCheckClassPath(String checkClassPath) {
        this.checkClassPath = checkClassPath;
    }

    public String getPayClassPath() {
        return payClassPath;
    }

    public void setPayClassPath(String payClassPath) {
        this.payClassPath = payClassPath;
    }
}
