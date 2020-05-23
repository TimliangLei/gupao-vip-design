package com.dream.ltl.app.dbroute.service;


import com.dream.ltl.app.dbroute.dao.OrderDao;
import com.dream.ltl.app.dbroute.pojo.Order;

public class OrderService implements IOrderService {

    private OrderDao orderDao = new OrderDao();

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
