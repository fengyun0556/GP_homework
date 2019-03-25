package com.gupao.pattern.decoratorAndObserver.decorator;

public class BatterCakeTest {
    public static void main(String[] args) {
        BatterCake batterCake;
        batterCake = new BaseBatterCake();

        batterCake = new EggBatterCakeDecorator(batterCake);
        batterCake = new EggBatterCakeDecorator(batterCake);

        batterCake = new SausageDecorator(batterCake);
        batterCake = new SausageDecorator(batterCake);
        batterCake = new SausageDecorator(batterCake);

        System.out.println(batterCake.getMsg() + ",sum price : " + batterCake.getPrice());
    }
}
