package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test9_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        byteBuffer1.position(5);
        ByteBuffer byteBuffer2 = byteBuffer1.slice();
        byteBuffer2.position(0);
        for (int i = byteBuffer2.position(); i < byteBuffer2.capacity(); i++) {
            System.out.print(byteBuffer2.get() + " ");
        }
        System.out.println();
        byteBuffer2.rewind();
        System.out.println("byteBuffer1.position()=" + byteBuffer1.position() +
                ",byteBuffer1.capacity()=" + byteBuffer1.capacity() +
                ",byteBuffer1.limit()="+byteBuffer1.limit());
        System.out.println("byteBuffer2.position()=" + byteBuffer2.position() +
                ",byteBuffer2.capacity()=" + byteBuffer2.capacity() +
                ",byteBuffer2.limit()="+byteBuffer2.limit());
        byteBuffer2.put(0, (byte) 111);
        byte[] byteArray1 = byteBuffer1.array();
        byte[] byteArray2 = byteBuffer2.array();
        for (int i = 0; i < byteArray1.length; i++) {
            System.out.print(byteArray1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < byteArray2.length; i++) {
            System.out.print(byteArray2[i] + " ");
        }


    }
}
