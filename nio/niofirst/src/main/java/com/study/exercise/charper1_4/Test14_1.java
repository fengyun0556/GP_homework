package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Test14_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
        byteBuffer1.order(ByteOrder.BIG_ENDIAN);
        byteBuffer1.putInt(123);
        byteBuffer1.putInt(456);
        byteBuffer1.flip();
        System.out.println(byteBuffer1.getInt());
        System.out.println(byteBuffer1.getInt());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteBuffer1.array());
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(byteBuffer2.getInt());
        System.out.println(byteBuffer2.getInt());
     }
}
