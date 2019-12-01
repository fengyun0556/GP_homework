package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test7_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer.isDirect());
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
        System.out.println(byteBuffer1.isDirect());
    }
}
