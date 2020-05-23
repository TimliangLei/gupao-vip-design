package com.dream.ltl.app.pattern.composite.safe;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private String name = null;
    private Integer level = null;
    private List<FileSystem> subDirs;

    public Directory(String name, Integer level) {
        this.name = name;
        this.level = level;
        this.subDirs = new ArrayList<>();

    }

    @Override
    public void show() {
        System.out.println(this.name);

        for (FileSystem dir:subDirs){
            if (this.level != null){
                for (int i = 0; i < this.level; i++){
                    System.out.print("     ");
                }
                for (int i = 0; i < this.level; i++){
                    if (i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            dir.show();
        }
    }


    public boolean add(FileSystem directory){
        return this.subDirs.add(directory);
    }
    public boolean remove(Directory directory){
        return this.subDirs.remove(directory);
    }
    public FileSystem get(int index){
        return this.subDirs.get(index);
    }

}
