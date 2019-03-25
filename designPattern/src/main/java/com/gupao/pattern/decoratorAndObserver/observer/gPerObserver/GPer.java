package com.gupao.pattern.decoratorAndObserver.observer.gPerObserver;

import java.util.Observable;

public class GPer extends Observable {

    private volatile static GPer gPer;

    private GPer(){}

    public static GPer getInstance(){
        if (gPer == null){
            synchronized (GPer.class){
                if (gPer == null){
                    gPer = new GPer();
                }
            }
        }
        return gPer;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getName() + "在咕泡社区上提交问题：" + question.getContext());
        setChanged();
        notifyObservers(question);
    }

}
