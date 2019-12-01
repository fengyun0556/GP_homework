package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test8 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.putChar('a');
        byteBuffer.putChar(2,'b');
        byteBuffer.position(4);
        byteBuffer.putDouble(1.1);
        byteBuffer.putDouble(12, 1.2);
        byteBuffer.position(20);
        byteBuffer.putFloat(2.1F);
        byteBuffer.putFloat(24, 2.2F);
        byteBuffer.position(28);
        byteBuffer.putInt(31);
        byteBuffer.putInt(32,32);
        byteBuffer.position(36);
        byteBuffer.putLong(41L);
        byteBuffer.putLong(44, 42L);
        byteBuffer.position(52);
        byteBuffer.putShort((short)51);
        byteBuffer.putShort(54, (short)52);
        byteBuffer.position(0);
        byte[] byteArrayOut = byteBuffer.array();
        for (int i = 0; i < byteArrayOut.length; i++) {
            
        }
        System.out.println();
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getChar(2));
        byteBuffer.position(4);
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getDouble(12));
        byteBuffer.position(20);
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getFloat(24));
        byteBuffer.position(28);
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt(32));
        byteBuffer.position(36);
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getLong(44));
        byteBuffer.position(52);
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getShort(54));
    }
}
