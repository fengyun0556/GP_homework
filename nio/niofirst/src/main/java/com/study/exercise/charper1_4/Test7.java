package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test7 {
    public static void main(String[] args) {
        byte[] byteArray1 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray1);
        byte[] byteArray2 = {55,66,77};
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray2);
        byteBuffer1.position(4);
        byteBuffer2.position(1);
        byteBuffer1.put(byteArray2);
        System.out.println("byteBuffer1被改变"+byteBuffer1.position());
        System.out.println("byteBuffer2被改变"+byteBuffer2.position());
        byte[] byteArrayOut = byteBuffer1.array();
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i] + " ");
        }
    }
}
