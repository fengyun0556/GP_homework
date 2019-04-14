package com.gupaoedu.spring.framework.beans;

import lombok.Data;

@Data
public class GPBeanDefinition {
    private String beanClassName;
    private boolean lazyInit;
    private String factoryBeanName;
}
