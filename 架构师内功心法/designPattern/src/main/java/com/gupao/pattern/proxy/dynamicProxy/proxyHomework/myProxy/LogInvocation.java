package com.gupao.pattern.proxy.dynamicProxy.proxyHomework.myProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocation implements InvocationHandler {

    private Object target;

    public LogInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long time = System.nanoTime();
        Object object = method.invoke(this.target, args);
        System.out.println("耗时：" + (System.nanoTime() - time));
        return object;
    }
}
