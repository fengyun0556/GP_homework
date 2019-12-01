package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test17_5 {
    public static void main(String[] args) {
        byte[] byteArray1 = {3,4,5};
        byte[] byteArray2 = {1,2,3,104,5,6,7,8,9,10};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray2);
        byteBuffer1.position(0);
        byteBuffer2.position(2);
        System.out.println("A="+byteBuffer1.compareTo(byteBuffer2));
    }
}
