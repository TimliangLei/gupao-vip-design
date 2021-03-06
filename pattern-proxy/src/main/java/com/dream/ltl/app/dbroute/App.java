package com.dream.ltl.app.dbroute;

import com.dream.ltl.app.dbroute.pojo.Order;
import com.dream.ltl.app.dbroute.proxy.DymicProxy;
import com.dream.ltl.app.dbroute.service.IOrderService;
import com.dream.ltl.app.dbroute.service.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2020/03/01");
            order.setCreateTime(date.getTime());

//            IOrderService orderService = new StaticProxy(new OrderService());
            IOrderService orderService = (IOrderService) new DymicProxy().getIntance(new OrderService());

            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
