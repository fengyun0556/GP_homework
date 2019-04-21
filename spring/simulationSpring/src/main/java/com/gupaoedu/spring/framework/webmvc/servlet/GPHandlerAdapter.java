package com.gupaoedu.spring.framework.webmvc.servlet;

import com.gupaoedu.spring.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GPHandlerAdapter {

    public boolean supports(Object handler){
        return handler instanceof GPHandlerAdapter;
    }

    GPModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws InvocationTargetException, IllegalAccessException {
        GPHandlerMapping handlerMapping = (GPHandlerMapping) handler;

        Map<String, Integer> paramIndexMapping = new HashMap<>();

        //提取方法中加了注解的参数
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation annotation : pa[i]) {
                if (annotation instanceof GPRequestParam){
                    String paramName = ((GPRequestParam) annotation).value();
                    if (!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }

        //提取方法中的request和response参数
        Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> type = paramTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class){
                paramIndexMapping.put(type.getName(), i);
            }
        }

        //获得方法的形参列表
        Map<String, String[]> params = request.getParameterMap();

        //实参列表
        Object[] paramValues = new Object[paramTypes.length];

        for (Map.Entry<String, String[]> param : params.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "")
                    .replaceAll("\\s", ",");
            if (!paramIndexMapping.containsKey(param.getKey())) continue;
            int index = paramIndexMapping.get(param.getKey());
            paramValues[index] = caseStringValue(value, paramTypes[index]);
        }

        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[index] = request;
        }

        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[index] = response;
        }

        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
        if (result == null || result instanceof Void) return null;
        boolean isModelAndVIew = handlerMapping.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndVIew) return (GPModelAndView) result;

        return null;
    }

    private Object caseStringValue(String value, Class<?> paramType) {
        if (String.class == paramType) return value;
        if (Integer.class == paramType) return Integer.valueOf(value);
        if (Double.class == paramType) return Double.valueOf(value);
        return value;
    }
}
