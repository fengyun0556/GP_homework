package com.gupao.pattern.decoratorAndObserver.observer.gPerObserver;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;

        System.out.println(this.name + "老师，您好。" + question.getName() + "给您提了个问题，问题是：" + question.getContext());
    }
}
