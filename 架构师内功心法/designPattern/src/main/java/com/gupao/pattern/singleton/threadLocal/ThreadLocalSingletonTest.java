package com.gupao.pattern.singleton.threadLocal;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        Thread thread0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        });

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
            System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        });

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

    }



}
