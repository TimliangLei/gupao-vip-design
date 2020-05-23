package com.dream.ltl.app.prototype.shallow.pojo;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//建造模式本来就不是单例模式


public class ConCreatePrototype implements Cloneable , Serializable {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    private int age;
    private String name;
    private List<String> hobbies;

    private static ConCreatePrototype instance = new ConCreatePrototype();

    private ConCreatePrototype() {
    }

    public static ConCreatePrototype getInstance(){
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ConCreatePrototype deepCloneHobbies(){
//        硬编码 不推荐
        try {
            ConCreatePrototype concreatePrototype = (ConCreatePrototype) super.clone();
            concreatePrototype.hobbies = (List) ((ArrayList) concreatePrototype.hobbies).clone();
            return concreatePrototype;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConCreatePrototype deepCloneByJSON(){
        String str = JSON.toJSONString(this);

        ConCreatePrototype object = JSON.parseObject(str, ConCreatePrototype.class);
        return  object;
    }

    public ConCreatePrototype deepClone(){
//        性能不好
//        占用IO
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConCreatePrototype) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConcreatePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
