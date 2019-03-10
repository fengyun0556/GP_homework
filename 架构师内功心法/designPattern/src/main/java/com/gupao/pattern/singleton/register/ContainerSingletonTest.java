package com.gupao.pattern.singleton.register;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        String className = "com.gupao.pattern.singleton.register.ContainerSingleton";
        Object obj = ContainerSingleton.getInstance(className);
        System.out.println(obj);
    }
}
