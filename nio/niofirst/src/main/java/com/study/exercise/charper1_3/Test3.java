package com.study.exercise.charper1_3;

import java.nio.CharBuffer;

public class Test3 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity() = " + charBuffer.capacity() + " limit()=" + charBuffer.limit()
                + " position()=" + charBuffer.position());
        charBuffer.position(2);
        System.out.println("B capacity() = " + charBuffer.capacity() + " limit()=" + charBuffer.limit()
                + " position()=" + charBuffer.position());
        charBuffer.put('z');
        for (char c : charArray) {
            System.out.println(c);
        }

    }
}
