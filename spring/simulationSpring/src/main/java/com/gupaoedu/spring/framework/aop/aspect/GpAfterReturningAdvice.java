package com.gupaoedu.spring.framework.aop.aspect;

import com.gupaoedu.spring.framework.aop.intercept.GPMethodInterceptor;
import com.gupaoedu.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

public class GpAfterReturningAdvice extends GPAbstractAspectAdvice implements GPAdvice, GPMethodInterceptor {

    private GPJoinPoint joinPoint;

    public GpAfterReturningAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable{
        invokeAdviceMethod(joinPoint, returnValue, null);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        Object retVal = mi.proceed();
        this.joinPoint = mi;
        this.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
        return retVal;
    }
}
