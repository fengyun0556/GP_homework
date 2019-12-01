package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test6_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put(byteArrayIn1);
        byteBuffer.put(2, (byte) 127);
        System.out.println(byteBuffer.get(2));
        byteBuffer.position(0);
        byte[] byteArrayOut = new byte[byteBuffer.capacity()];
        byteBuffer.get(byteArrayOut, 0, byteArrayOut.length);
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i] + " ");
        }


    }
}
