package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray, 2, 4);
        System.out.println("byteBuffer1.capacity="+byteBuffer1.capacity()+
                ",limit="+byteBuffer1.limit()+",position="+byteBuffer1.position());
        System.out.println("byteBuffer2.capacity="+byteBuffer2.capacity()+
                ",limit="+byteBuffer2.limit()+",position="+byteBuffer2.position());
        byteBuffer2.position(0);
        System.out.println("byteBuffer2.capacity="+byteBuffer2.capacity()+
                ",limit="+byteBuffer2.limit()+",position="+byteBuffer2.position());
        System.out.println(byteBuffer2.get());
    }
}
