package com.gupao.pattern.decoratorAndObserver.decorator;

public class EggBatterCakeDecorator extends BatterCakeDecorator {
    public EggBatterCakeDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomeThing() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
