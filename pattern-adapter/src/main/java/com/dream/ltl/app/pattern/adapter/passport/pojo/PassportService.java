package com.dream.ltl.app.pattern.adapter.passport.pojo;

public class PassportService {
    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password){
        System.out.println("regist--"+username+":"+password);
        return new ResultMsg(200,username,password);
    }
    public ResultMsg login(String username,String password){
        System.out.println("login--"+username+":"+password);
        return null;
    }
}
