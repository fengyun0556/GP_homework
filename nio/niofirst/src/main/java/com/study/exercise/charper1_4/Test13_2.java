package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test13_2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.putInt(123);
        byteBuffer.putInt(456);
        byteBuffer.flip();
        System.out.println("byteBuffer.position = "+byteBuffer.position()+
                ",value = "+byteBuffer.getInt());
        System.out.println("byteBuffer.position = "+byteBuffer.position()+
                ",value = "+byteBuffer.getInt());
        System.out.println();
        IntBuffer intBuffer = IntBuffer.allocate(10);
        intBuffer.put(456);
        intBuffer.put(789);
        intBuffer.flip();
        System.out.println("intBuffer.position = "+intBuffer.position()+
                ",value = "+intBuffer.get());
        System.out.println("intBuffer.position = "+intBuffer.position()+
                ",value = "+intBuffer.get());
    }
}
