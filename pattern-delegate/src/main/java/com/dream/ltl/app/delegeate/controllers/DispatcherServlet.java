package com.dream.ltl.app.delegeate.controllers;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        Method method = handlerMapping.get(req.getRequestURI());
//        method.invoke()
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            handlerMapping.put("/web/getMemberById.json",MemberController.class.getMethod("getMemberById",new Class[]{String.class}));
            handlerMapping.put("/web/getOrderById.json",OrderController.class.getMethod("getOrderById",new Class[]{String.class}));
            handlerMapping.put("/web/getSystemById.json",SystemController.class.getMethod("getSystemById",new Class[]{String.class}));



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
