package com.study.exercise.charper1_5;

import java.nio.CharBuffer;

public class Test2 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append("abcdefg");
        charBuffer.position(2);
        System.out.println(charBuffer.charAt(0));
        System.out.println(charBuffer.charAt(1));
        System.out.println(charBuffer.charAt(2));
    }
}
