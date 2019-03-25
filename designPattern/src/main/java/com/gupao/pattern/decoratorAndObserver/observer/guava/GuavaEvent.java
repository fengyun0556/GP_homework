package com.gupao.pattern.decoratorAndObserver.observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

//    @Subscribe
    public void subscribe(String str){
        System.out.println("method subscribe parameter : " + str);
    }

    @Subscribe
    public void subscribe1(String str, String str1){
        System.out.println("method subscribe1 parameter : " + str);
    }
}
