package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test12_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//        byteBuffer.put((byte) 1);
//        byteBuffer.put((byte) 2);
        System.out.println(byteBuffer.hasArray());
    }
}
