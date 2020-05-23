package com.dream.ltl.app.prototype.shallow;

import com.dream.ltl.app.prototype.shallow.pojo.ConCreatePrototype;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConCreatePrototype prototype = ConCreatePrototype.getInstance();
        prototype.setAge(19);
        prototype.setName("ltl");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("write");
        hobbies.add("art");

        prototype.setHobbies(hobbies);


        ConCreatePrototype cloneType = (ConCreatePrototype) prototype.deepCloneByJSON();
        cloneType.getHobbies().add("gym");
        System.out.println(cloneType);
        System.out.println(prototype);
        System.out.println(cloneType == prototype);

    }
}
