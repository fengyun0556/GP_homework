package com.gupao.pattern.singleton.lazyInner;

public class LazyInnerSingleTonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            LazyInnerSingleTon lazyInnerSingleTon = LazyInnerSingleTon.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + lazyInnerSingleTon);
        }).start();

        new Thread(() -> {
            LazyInnerSingleTon lazyInnerSingleTon = LazyInnerSingleTon.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + lazyInnerSingleTon);
        }).start();

        System.out.println("END");
    }
}
