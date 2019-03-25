package com.gupao.pattern.decoratorAndObserver.homework.guvaua;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void subscribe(String str){
        System.out.println("method subscribe parameter : " + str);
    }
}
