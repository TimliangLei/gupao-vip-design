package com.dream.ltl.delegeate.company;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String,IEmployee> employeeMap = new HashMap<>();

    public Leader(){
        employeeMap.put("爬虫",new EmployeeA());
        employeeMap.put("海报图", new EmployeeB());

    }

    @Override
    public void doing(String task) {
        if (!employeeMap.containsKey(task)){
            System.out.println("这个任务"+task+"超出我的能力范围");
        }
        employeeMap.get(task).doing(task);
        /*
        if("爬虫".equals(task)){
            new EmployeeA().doing(task);
        }else if ("海报图".equals(task)){
            new EmployeeB().doing(task);
        }else {
            System.out.println("这个任务"+task+"超出我的能力范围");
        }
        */
    }
}
