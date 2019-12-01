package com.study.exercise.charper1_3;

import java.nio.CharBuffer;

public class Test2 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a','b','c','d','e'};
        CharBuffer buffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity() = " + buffer.capacity() + " limit()=" + buffer.limit());
        buffer.limit(3);
        System.out.println("B capacity() = " + buffer.capacity() + " limit()=" + buffer.limit());
        buffer.put(0, 'o');
        buffer.put(1, 'p');
        buffer.put(2, 'q');
        buffer.put(3, 'r');
        buffer.put(4, 's');
        buffer.put(5, 't');
        buffer.put(6, 'u');
    }
}
