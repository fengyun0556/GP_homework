package com.study.exercise.charper1_5;

import java.nio.CharBuffer;

public class Test4 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.wrap("abcdefg", 3, 5);
        System.out.println("capacity=" + charBuffer.capacity() + " limit=" + charBuffer.limit() +
                " position=" + charBuffer.position());
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get(i) + " ");
        }
        charBuffer.put("a");
    }
}
