package com.gupaoedu.spring.framework.aop.aspect;

import java.lang.reflect.Method;

public interface GPJoinPoint {
    Method getMethod();
    Object[] getArguments();
    Object getThis();
}
