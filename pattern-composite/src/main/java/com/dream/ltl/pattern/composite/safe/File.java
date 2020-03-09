package com.dream.ltl.pattern.composite.safe;

public class File implements FileSystem {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
