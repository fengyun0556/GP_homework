package com.gupao.pattern.proxy.staticProxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Subject subject = new ProxySubject(new RealSubject());
        subject.request();
    }
}
