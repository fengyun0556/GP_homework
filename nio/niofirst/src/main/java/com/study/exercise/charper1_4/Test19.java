package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test19 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1, 2, 3, 4, 5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = byteBuffer1.duplicate();
        System.out.println("A capacity = " + byteBuffer1.capacity()
                + ",position = " + byteBuffer1.position()
                + ",limit = " + byteBuffer1.limit());
        System.out.println("B capacity = " + byteBuffer2.capacity()
                + ",position = " + byteBuffer2.position()
                + ",limit = " + byteBuffer2.limit());
        byteBuffer2.put(1, (byte) 22);
        byteBuffer2.position(3);
        System.out.println("C capacity = " + byteBuffer1.capacity()
                + ",position = " + byteBuffer1.position()
                + ",limit = " + byteBuffer1.limit());
        System.out.println("D capacity = " + byteBuffer2.capacity()
                + ",position = " + byteBuffer2.position()
                + ",limit = " + byteBuffer2.limit());
        byteBuffer1.position(0);
        for (int i = 0; i < byteBuffer1.limit(); i++) {
            System.out.print(byteBuffer1.get() + " ");
        }
    }
}
