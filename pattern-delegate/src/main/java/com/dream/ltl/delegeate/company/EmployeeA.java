package com.dream.ltl.delegeate.company;

public class EmployeeA implements IEmployee {
    protected String goodAt = "编程";
    @Override
    public void doing(String task) {
        System.out.println("我是员工A，我擅长"+goodAt+"，现在开始做"+task+"工作");
    }
}
