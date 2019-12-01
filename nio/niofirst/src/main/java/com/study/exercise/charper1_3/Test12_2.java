package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test12_2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.position(0);
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print(byteBuffer.get());
        }
        System.out.println();
        System.out.println(byteBuffer.hasArray());
    }
}
