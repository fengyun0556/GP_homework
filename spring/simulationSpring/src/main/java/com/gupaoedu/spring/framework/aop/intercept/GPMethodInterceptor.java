package com.gupaoedu.spring.framework.aop.intercept;

public interface GPMethodInterceptor {
    Object invoke(GPMethodInvocation mi) throws Throwable;
}
