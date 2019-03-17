package com.gupao.pattern.singleton.doubleCheck;

public class DoubleCheckSingletonTest {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + DoubleCheckSingleton.getInstance());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + DoubleCheckSingleton.getInstance());
            }
        }.start();

        System.out.println("END");
    }
}
