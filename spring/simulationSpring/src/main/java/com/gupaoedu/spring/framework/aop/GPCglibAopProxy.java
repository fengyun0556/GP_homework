package com.gupaoedu.spring.framework.aop;

import com.gupaoedu.spring.framework.aop.support.GPAdvisedSupport;

public class GPCglibAopProxy implements GPAopProxy {

    private GPAdvisedSupport config;

    public GPCglibAopProxy(GPAdvisedSupport config) {
        this.config = config;
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
