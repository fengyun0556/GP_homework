package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test5 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8};
        byte[] byteArrayIn2 = {55,66,77,88};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put(byteArrayIn1);
        byteBuffer.position(2);
        byteBuffer.put(byteArrayIn2, 1,2);
        System.out.print("A=");
        byte[] getByte = byteBuffer.array();
        for (int i = 0; i < getByte.length; i++) {
            System.out.print(getByte[i] + " ");
        }
        System.out.println();
        byteBuffer.position(1);
        byte[] byteArrayOut = new byte[byteBuffer.capacity()];
        byteBuffer.get(byteArrayOut, 3,4);
        System.out.print("B=");
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i] + " ");
        }
    }
}
