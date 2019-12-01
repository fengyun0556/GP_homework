package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(200);
        System.out.println("byteBuffer1.position()="+byteBuffer1.position()+",limit="+byteBuffer1.limit());
        System.out.println("byteBuffer2.position()="+byteBuffer2.position()+",limit="+byteBuffer2.limit());
        System.out.println("byteBuffer1="+byteBuffer1+",isDirect="+byteBuffer1.isDirect());
        System.out.println("byteBuffer2="+byteBuffer2+",isDirect="+byteBuffer2.isDirect());
    }
}
