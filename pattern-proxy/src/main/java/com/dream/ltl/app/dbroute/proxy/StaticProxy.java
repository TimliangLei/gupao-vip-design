package com.dream.ltl.app.dbroute.proxy;

import com.dream.ltl.app.dbroute.service.IOrderService;
import com.dream.ltl.app.dbroute.db.DynamicDataSource;
import com.dream.ltl.app.dbroute.pojo.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticProxy implements IOrderService {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public StaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSource.set(dbRouter);
        this.orderService.createOrder(order);
        DynamicDataSource.restore();
        return 0;
    }
}
