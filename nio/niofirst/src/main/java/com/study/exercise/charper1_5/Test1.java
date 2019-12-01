package com.study.exercise.charper1_5;

import java.nio.CharBuffer;

public class Test1 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(15);
        System.out.println("A "+ charBuffer.position());
        charBuffer.append('a');
        System.out.println("B "+ charBuffer.position());
        charBuffer.append("bcdef");
        System.out.println("C "+ charBuffer.position());
        charBuffer.append("abchijklmn", 3, 8);
        System.out.println("D "+ charBuffer.position());
        char[] newArray = charBuffer.array();
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        System.out.println("charBuffer.capacity = "+charBuffer.capacity());
    }
}
