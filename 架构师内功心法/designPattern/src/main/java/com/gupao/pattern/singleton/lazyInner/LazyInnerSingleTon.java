package com.gupao.pattern.singleton.lazyInner;

public class LazyInnerSingleTon {
    private LazyInnerSingleTon(){}

    public static final LazyInnerSingleTon getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerSingleTon LAZY = new LazyInnerSingleTon();
    }
}
