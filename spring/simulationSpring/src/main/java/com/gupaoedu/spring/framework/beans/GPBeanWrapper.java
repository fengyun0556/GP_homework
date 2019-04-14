package com.gupaoedu.spring.framework.beans;

public class GPBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }

    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }
}
