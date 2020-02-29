package com.dream.ltl.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcreatePrototype prototype = ConcreatePrototype.getInstance();
        prototype.setAge(19);
        prototype.setName("ltl");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("write");
        hobbies.add("art");

        prototype.setHobbies(hobbies);


        ConcreatePrototype cloneType = (ConcreatePrototype) prototype.deepCloneHobbies();
        cloneType.getHobbies().add("gym");
        System.out.println(cloneType);
        System.out.println(prototype);
        System.out.println(cloneType == prototype);

    }
}
