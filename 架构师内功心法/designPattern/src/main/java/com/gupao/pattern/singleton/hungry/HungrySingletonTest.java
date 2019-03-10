package com.gupao.pattern.singleton.hungry;

public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
    }
}
