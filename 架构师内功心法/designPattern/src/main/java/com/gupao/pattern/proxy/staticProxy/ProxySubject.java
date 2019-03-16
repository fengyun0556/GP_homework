package com.gupao.pattern.proxy.staticProxy;

public class ProxySubject implements Subject {
    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        this.before();
        this.realSubject.request();
        this.after();
    }

    private void before(){
        System.out.println("前置增强");
    }

    private void after(){
        System.out.println("后置增强");
    }

}
