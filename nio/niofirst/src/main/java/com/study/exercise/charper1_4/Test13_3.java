package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test13_3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        byteBuffer.putInt(123);
        byteBuffer.putInt(456);
        byteBuffer.flip();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
        System.out.println();
        System.out.println(byteBuffer);
        System.out.println(intBuffer);
    }
}
