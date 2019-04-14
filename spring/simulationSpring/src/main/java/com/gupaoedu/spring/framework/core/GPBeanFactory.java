package com.gupaoedu.spring.framework.core;

public interface GPBeanFactory {
    /**
     * 根据beanName从IOC容器中获得一个实例Bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
