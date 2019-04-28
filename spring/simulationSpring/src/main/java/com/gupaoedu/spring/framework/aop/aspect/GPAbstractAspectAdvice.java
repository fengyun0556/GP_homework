package com.gupaoedu.spring.framework.aop.aspect;

import java.lang.reflect.Method;

public abstract class GPAbstractAspectAdvice implements GPAdvice{

    private Method aspectMethod;
    private Object aspectTarget;

    public GPAbstractAspectAdvice(Method aspectMethod, Object aspectTarget) {
        this.aspectMethod = aspectMethod;
        this.aspectTarget = aspectTarget;
    }

    protected Object invokeAdviceMethod(GPJoinPoint joinPoint, Object returnValue, Throwable ex) throws Throwable{
        Class<?>[] paramTypes = this.aspectMethod.getParameterTypes();
        if (null == paramTypes || paramTypes.length == 0){
            return this.aspectMethod.invoke(aspectTarget);
        } else {
            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                if (paramTypes[i] == GPJoinPoint.class){
                    args[i] = joinPoint;
                } else if(paramTypes[i] == Throwable.class){
                    args[i] = ex;
                } else if (paramTypes[i] == Object.class){
                    args[i] = returnValue;
                }
            }
            return this.aspectMethod.invoke(aspectTarget, args);
        }
    }
}
