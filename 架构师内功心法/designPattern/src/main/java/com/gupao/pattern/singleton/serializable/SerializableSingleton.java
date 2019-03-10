package com.gupao.pattern.singleton.serializable;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    public final static SerializableSingleton INSTANCE = new SerializableSingleton();
    private SerializableSingleton(){}

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
