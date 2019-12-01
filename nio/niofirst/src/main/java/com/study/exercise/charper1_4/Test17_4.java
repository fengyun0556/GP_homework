package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test17_4 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {3,4,5};
        byte[] byteArrayIn2 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArrayIn2);
        byteBuffer1.position(0);
        byteBuffer1.limit(3);
        byteBuffer2.position(2);
        byteBuffer2.limit(5);
        System.out.println(byteBuffer1.equals(byteBuffer2));

        byteBuffer2.put(3, (byte) 44);
        System.out.println(byteBuffer1.equals(byteBuffer2));
    }
}
