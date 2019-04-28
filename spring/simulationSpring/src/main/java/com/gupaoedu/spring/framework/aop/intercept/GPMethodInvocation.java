package com.gupaoedu.spring.framework.aop.intercept;

import com.gupaoedu.spring.framework.aop.aspect.GPJoinPoint;

import java.lang.reflect.Method;
import java.util.List;

public class GPMethodInvocation implements GPJoinPoint {

    private Object proxy;
    private Method method;
    private Object target;
    private Class<?> targetClass;
    private Object[] arguments;
    private List<Object> interceptorsAndDynamicMethodMatchers;

    private int currentInterceptorIndex = -1;

    public GPMethodInvocation(Object proxy, Method method, Object target, Class<?> targetClass,
                              Object[] arguments, List<Object> interceptorsAndDynamicMethodMatchers) {
        this.proxy = proxy;
        this.method = method;
        this.target = target;
        this.targetClass = targetClass;
        this.arguments = arguments;
        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }

    public Object proceed() throws Throwable{
        if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1){
            return this.method.invoke(this.target, this.arguments);
        }
        Object interceptorOrIntercepterAdvice =
                this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
        if (interceptorOrIntercepterAdvice instanceof GPMethodInterceptor){
            GPMethodInterceptor mi = (GPMethodInterceptor) interceptorOrIntercepterAdvice;
            return mi.invoke(this);
        } else {
            return proceed();
        }
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object getThis() {
        return this.target;
    }
}
