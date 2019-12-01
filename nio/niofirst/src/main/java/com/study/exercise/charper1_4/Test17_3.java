package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test17_3 {
    public static void main(String[] args) {
        byte[] byteArray1 = {3,4,5};
        byte[] byteArray2 = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray2);
        byteBuffer1.position(0);
        byteBuffer2.position(2);
        System.out.println(byteBuffer1.equals(byteBuffer2));
    }
}
