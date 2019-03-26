package com.gupao.pattern.decoratorAndObserver.homework.guvaua;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        Question question = new Question("小明", "观察者模式的应用场景有哪些？");

        Teacher teacher = new Teacher("Tom");
        eventBus.register(teacher);
        eventBus.post(question);

    }
}
