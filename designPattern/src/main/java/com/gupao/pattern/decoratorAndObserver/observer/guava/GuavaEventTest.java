package com.gupao.pattern.decoratorAndObserver.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");
//        String[] strArr = new String[]{"Tom", "Mic"};
//        eventBus.post(strArr);

    }
}
