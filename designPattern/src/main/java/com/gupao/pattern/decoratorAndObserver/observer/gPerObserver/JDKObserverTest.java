package com.gupao.pattern.decoratorAndObserver.observer.gPerObserver;

public class JDKObserverTest {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();

        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        Question question = new Question();
        question.setName("小明");
        question.setContext("观察者模式的应用场景是什么？");

        gPer.addObserver(tom);
        gPer.addObserver(mic);
        gPer.publishQuestion(question);
    }
}
