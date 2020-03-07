package com.dream.ltl.dbroute.dao;

import com.dream.ltl.dbroute.pojo.Order;

public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
