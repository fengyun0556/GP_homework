package com.gupaoedu.spring.framework.aop.aspect;

import com.gupaoedu.spring.framework.aop.intercept.GPMethodInterceptor;
import com.gupaoedu.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

public class GPAfterThrowingAdvice extends GPAbstractAspectAdvice implements GPAdvice, GPMethodInterceptor {

    private String throwingName;

    private GPMethodInvocation mi;

    public GPAfterThrowingAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Exception e){
            invokeAdviceMethod(mi, null, e.getCause());
            throw e;
        }
    }
}
