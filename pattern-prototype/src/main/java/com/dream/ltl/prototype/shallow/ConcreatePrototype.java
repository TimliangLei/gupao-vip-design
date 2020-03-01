package com.dream.ltl.prototype.shallow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//建造模式本来就不是单例模式

@Data
public class ConcreatePrototype implements Cloneable , Serializable {
    private int age;
    private String name;
    private List<String> hobbies;

    private static ConcreatePrototype instance = new ConcreatePrototype();

    private ConcreatePrototype() {
    }

    public static ConcreatePrototype getInstance(){
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ConcreatePrototype deepCloneHobbies(){
//        硬编码 不推荐
        try {
            ConcreatePrototype concreatePrototype = (ConcreatePrototype) super.clone();
            concreatePrototype.hobbies = (List) ((ArrayList) concreatePrototype.hobbies).clone();
            return concreatePrototype;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConcreatePrototype deepCloneByJSON(){
        String str = JSON.toJSONString(this);

        ConcreatePrototype object = JSON.parseObject(str,ConcreatePrototype.class);
        return  object;
    }

    public ConcreatePrototype deepClone(){
//        性能不好
//        占用IO
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcreatePrototype) ois.readObject();
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
