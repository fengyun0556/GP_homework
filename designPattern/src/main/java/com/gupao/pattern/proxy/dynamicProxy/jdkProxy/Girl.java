package com.gupao.pattern.proxy.dynamicProxy.jdkProxy;

import com.gupao.pattern.proxy.dynamicProxy.Person;

public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
