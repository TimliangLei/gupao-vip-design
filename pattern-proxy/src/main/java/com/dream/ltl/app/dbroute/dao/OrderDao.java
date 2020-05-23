package com.dream.ltl.app.dbroute.dao;

import com.dream.ltl.app.dbroute.pojo.Order;

public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
