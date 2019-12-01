package com.study.exercise.charper1_3;

import java.nio.CharBuffer;

public class Test4 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity() = " + charBuffer.capacity() + " limit()=" + charBuffer.limit()
                + " position()=" + charBuffer.position());
        System.out.println("C remaining()=" + charBuffer.remaining());
        charBuffer.position(2);
        System.out.println("B capacity() = " + charBuffer.capacity() + " limit()=" + charBuffer.limit()
                + " position()=" + charBuffer.position());
        System.out.println("C remaining()=" + charBuffer.remaining());
    }
}
