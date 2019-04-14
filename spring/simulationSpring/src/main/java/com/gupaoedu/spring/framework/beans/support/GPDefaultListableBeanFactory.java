package com.gupaoedu.spring.framework.beans.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gupaoedu.spring.framework.beans.GPBeanDefinition;
import com.gupaoedu.spring.framework.context.support.GPAbstractApplicationContext;

public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {
    //存储注册信息的BeanDefinition
    protected final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
}
