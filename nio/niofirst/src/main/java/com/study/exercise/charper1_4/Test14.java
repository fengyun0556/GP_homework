package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Test14 {
    public static void main(String[] args) {
        int value = 123456789;
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
        System.out.print(byteBuffer1.order()+" ");
        byteBuffer1.putInt(value);
        byte[] byteArray = byteBuffer1.array();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println();
        byteBuffer1 = ByteBuffer.allocate(4);
        System.out.println(byteBuffer1.order() + " ");
        byteBuffer1.order(ByteOrder.BIG_ENDIAN);
        System.out.print(byteBuffer1.order() + " ");
        byteBuffer1.putInt(value);
        byteArray = byteBuffer1.array();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println();
        byteBuffer1 = ByteBuffer.allocate(4);
        System.out.println(byteBuffer1.order());
        byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        System.out.print(byteBuffer1.order()+ " ");
        byteBuffer1.putInt(value);
        byteArray = byteBuffer1.array();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }
}
