package com.gupao.pattern.singleton.doubleCheck;

public class DoubleCheckSingleton {
    private DoubleCheckSingleton(){}

    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    public static DoubleCheckSingleton getInstance(){
        if (doubleCheckSingleton == null){
            synchronized (DoubleCheckSingleton.class){
                if (doubleCheckSingleton == null){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }

}
