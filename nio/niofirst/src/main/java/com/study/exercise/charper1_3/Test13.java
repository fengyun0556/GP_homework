package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test13 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.limit(3);
        byteBuffer.position(2);
        System.out.println("byteBuffer.hasRemaining="+byteBuffer.hasRemaining()+
                ",byteBuffer.remaining="+byteBuffer.remaining());
    }
}
