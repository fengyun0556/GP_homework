package com.study.exercise.charper1_5;

import java.nio.CharBuffer;

public class Test5 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.wrap("abcd");
        System.out.println("position="+charBuffer.position()+",remaining="+charBuffer.remaining()
        +",length="+charBuffer.length());
        System.out.println(charBuffer.get());
        System.out.println("position="+charBuffer.position()+",remaining="+charBuffer.remaining()
                +",length="+charBuffer.length());
        System.out.println(charBuffer.get());
        System.out.println("position="+charBuffer.position()+",remaining="+charBuffer.remaining()
                +",length="+charBuffer.length());
        System.out.println(charBuffer.get());
        System.out.println("position="+charBuffer.position()+",remaining="+charBuffer.remaining()
                +",length="+charBuffer.length());
        System.out.println(charBuffer.get());
        System.out.println("position="+charBuffer.position()+",remaining="+charBuffer.remaining()
                +",length="+charBuffer.length());
    }

}
