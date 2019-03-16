package com.gupao.pattern.proxy.staticProxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("真实对象执行方法");
    }
}
