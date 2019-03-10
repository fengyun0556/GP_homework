package com.gupao.pattern.singleton.register;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
    public static void main(String[] args) throws Exception {
        Class clazz = EnumSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
