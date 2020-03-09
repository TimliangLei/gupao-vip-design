package com.dream.ltl.pattern.composite.safe;

public class App {
    public static void main(String[] args) {
        Directory rootDir = new Directory("root",1);
        File file1 = new File("root1.txt");
        Directory dir1_1 = new Directory("acrosspm",2);
        File file2 = new File("acrosspm1.txt");
        Directory dir1_2 = new Directory("ltl",2);
        File file3 = new File("acrosspm1.txt");

        rootDir.add(dir1_1);
        rootDir.add(dir1_2);
        rootDir.add(file1);
        dir1_1.add(file2);
        dir1_2.add(file3);

        rootDir.show();
    }
}
