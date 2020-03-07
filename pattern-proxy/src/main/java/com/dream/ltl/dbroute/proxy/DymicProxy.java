package com.dream.ltl.dbroute.proxy;

import com.dream.ltl.dbroute.db.DynamicDataSource;
import com.dream.ltl.dbroute.service.IOrderService;
import com.dream.ltl.dynamicproxy.jdkproxy.IPerson;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DymicProxy implements InvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    IOrderService proxyObj;

    public Object getIntance(IOrderService proxyObj){
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args);
        Object object = method.invoke(proxyObj,args);
        later();
        return object;
    }

    private void later() {
        System.out.println("Proxy after method");

        DynamicDataSource.restore();
    }

    private void before(Object[] args) {
        System.out.println("Proxy before method");



        try {
            Method method = args[0].getClass().getDeclaredMethod("getCreateTime");
//            for(Method method:methods){
                System.out.println(method.getGenericReturnType());
                System.out.println(method.getReturnType());
//            }


            Long time = (Long) args[0].getClass().getDeclaredMethod("getCreateTime").invoke(args[0]);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("动态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSource.set(dbRouter);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
