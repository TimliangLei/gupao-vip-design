package com.dream.ltl.mvcframework.webmvc.servlet;

import com.dream.ltl.mvcframework.annotations.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GPHandlerAdapter {

    public GPModelAndView handler(HttpServletRequest req, HttpServletResponse resp, GPHandlerMapping handler) throws Exception {
        Map<String,Integer> paramIndexMapping = new HashMap<String, Integer>();

        Annotation[][] pa = handler.getMethod().getParameterAnnotations();
        for(int j = 0; j < pa.length;j++){
            for (Annotation a:pa[j]){
                if (a instanceof GPRequestParam){
                    String paramName = ((GPRequestParam) a).value();
                    if (!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName,j);
                    }
                }
            }
        }


        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++){
            Class parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class || parameterType == HttpServletResponse.class){
                paramIndexMapping.put(parameterType.getName(),i);
            }
        }

        Map<String,String[]> params = req.getParameterMap();
        Object[] parameterValues = new Object[parameterTypes.length];
        for (Map.Entry<String,String[]> param: params.entrySet()){
            String value = Arrays.toString(params.get(param.getKey()))
                    .replaceAll("\\[|\\]","")
                    .replaceAll("\\s+","");
            if (!paramIndexMapping.containsKey(param.getKey()))continue;

            int index = paramIndexMapping.get(param.getKey());
            parameterValues[index] = converte(value,parameterTypes[index]);

        }
        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            parameterValues[index] = req;
        }
        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            parameterValues[index] = resp;
        }


        Object result = handler.getMethod().invoke(handler.getController(),parameterValues);
        if (result == null || result instanceof Void) return null;

        boolean isModelAndView = handler.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndView) return (GPModelAndView)result;

        return null;
    }

    private Object converte(String value, Class<?> parameterType) {
        if (String.class == parameterType){
            return value;
        }else if (Integer.class == parameterType){
            return Integer.parseInt(value);
        }else if (Double.class == parameterType){
            return Double.parseDouble(value);
        }else if (Float.class == parameterType){
            return Float.parseFloat(value);
        }else {
            if (value!=null){
                return value;
            }
        }
        return null;
    }
}
