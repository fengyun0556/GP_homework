package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test6_2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.position(9);
        System.out.println(byteBuffer.position());
        byteBuffer.put(2, (byte) 127);
        System.out.println(byteBuffer.position());
        byteBuffer.rewind();
        byte[] byteArrayOut = new byte[byteBuffer.capacity()];
        byteBuffer.get(byteArrayOut, 0, byteArrayOut.length);
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i] + " ");
        }
    }
}
