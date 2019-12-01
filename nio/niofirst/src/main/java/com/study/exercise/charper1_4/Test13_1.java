package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test13_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("A1 = "+byteBuffer.position());
        byteBuffer.putInt(123);
        System.out.println("A2 = "+byteBuffer.position());
        byteBuffer.putInt(456);
        System.out.println("A3 = "+byteBuffer.position());
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("B1 = "+intBuffer.position());
        intBuffer.put(456);
        System.out.println("B2 = "+intBuffer.position());
        intBuffer.put(789);
        System.out.println("B3 = "+intBuffer.position());
    }
}
