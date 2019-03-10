package com.gupao.pattern.singleton.lazy;

public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ":" + lazySingleton);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ":" + lazySingleton);
            }
        }.start();

        System.out.println("END");
    }
}
