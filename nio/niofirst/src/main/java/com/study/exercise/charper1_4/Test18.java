package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test18 {
    public static void main(String[] args) {
        byte[] byteArrayIn = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn);
        byteBuffer1.position(2);
        System.out.println("byteBuffer1.capacity="+byteBuffer1.capacity()+
                ",limit="+byteBuffer1.limit()+",position="+byteBuffer1.position());
        ByteBuffer byteBuffer2 = byteBuffer1.slice();
        ByteBuffer byteBuffer3 = byteBuffer1.duplicate();
        ByteBuffer byteBuffer4 = byteBuffer1;
        System.out.println("byteBuffer2.capacity="+byteBuffer2.capacity()+
                ",limit="+byteBuffer2.limit()+",position="+byteBuffer2.position());
        System.out.println("byteBuffer3.capacity="+byteBuffer3.capacity()+
                ",limit="+byteBuffer3.limit()+",position="+byteBuffer3.position());
        byteBuffer2.position(0);
        for (int i = byteBuffer2.position(); i < byteBuffer2.limit(); i++) {
            System.out.print(byteBuffer2.get(i)+" ");
        }
        System.out.println();
        for (int i = byteBuffer3.position(); i < byteBuffer3.limit(); i++) {
            System.out.print(byteBuffer3.get(i)+" ");
        }
    }
}
