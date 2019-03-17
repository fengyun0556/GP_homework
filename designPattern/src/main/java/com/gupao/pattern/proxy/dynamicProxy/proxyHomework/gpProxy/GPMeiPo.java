package com.gupao.pattern.proxy.dynamicProxy.proxyHomework.gpProxy;

import java.lang.reflect.Method;

public class GPMeiPo implements GPInvocationHandler {

    private Object target;

    public Object getInstance(Object person){
        this.target = person;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj = method.invoke(this.target, args);
        this.after();
        return obj;
    }

    private void before(){
        System.out.println("媒婆前置增强");
    }

    private void after(){
        System.out.println("媒婆后置增强");
    }
}
