package com.gupao.pattern.singleton.hungry;

public class HungrySingleton {
    private HungrySingleton(){}
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
