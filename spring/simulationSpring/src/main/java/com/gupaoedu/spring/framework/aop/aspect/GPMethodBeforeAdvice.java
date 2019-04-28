package com.gupaoedu.spring.framework.aop.aspect;

import com.gupaoedu.spring.framework.aop.intercept.GPMethodInterceptor;
import com.gupaoedu.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

public class GPMethodBeforeAdvice extends GPAbstractAspectAdvice implements GPAdvice, GPMethodInterceptor {

    private GPJoinPoint joinPoint;

    public GPMethodBeforeAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    public void before(Method method, Object[] args, Object target) throws Throwable{
        invokeAdviceMethod(this.joinPoint, null, null);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        this.joinPoint = mi;
        this.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        return mi.proceed();
    }
}
