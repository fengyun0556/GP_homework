package com.gupao.pattern.singleton.register;

public enum EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData(){
        return data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
