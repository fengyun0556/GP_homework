package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test5 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("byteBuffer.capacity()="+byteBuffer.capacity());
        System.out.println(byteBuffer.position());
        byteBuffer.position(1);
        System.out.println(byteBuffer.position());
        byteBuffer.mark();
        System.out.println("byteBuffer.position()="+byteBuffer.position());
        byteBuffer.position(2);
        System.out.println(byteBuffer.position());
        byteBuffer.reset();
        System.out.println();
        System.out.println("byteBuffer.position()="+byteBuffer.position());
    }
}
