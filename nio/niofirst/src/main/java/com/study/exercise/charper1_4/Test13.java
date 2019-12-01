package com.study.exercise.charper1_4;

import java.nio.*;

public class Test13 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(32);
        byteBuffer1.putDouble(1.1);
        byteBuffer1.putDouble(1.2);
        byteBuffer1.putDouble(1.3);
        byteBuffer1.putDouble(1.4);
        byteBuffer1.flip();
        DoubleBuffer doubleBuffer = byteBuffer1.asDoubleBuffer();
        for (int i = 0; i < doubleBuffer.capacity(); i++) {
            System.out.print(doubleBuffer.get(i) + " ");
        }
        System.out.println();
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(16);
        byteBuffer2.putFloat(2.1F);
        byteBuffer2.putFloat(2.2F);
        byteBuffer2.putFloat(2.3F);
        byteBuffer2.putFloat(2.4F);
        byteBuffer2.flip();
        FloatBuffer floatBuffer = byteBuffer2.asFloatBuffer();
        for (int i = 0; i < floatBuffer.capacity(); i++) {
            System.out.print(floatBuffer.get(i)+" ");
        }
        System.out.println();
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(16);
        byteBuffer3.putInt(31);
        byteBuffer3.putInt(32);
        byteBuffer3.putInt(33);
        byteBuffer3.putInt(34);
        byteBuffer3.flip();
        IntBuffer intBuffer = byteBuffer3.asIntBuffer();
        for (int i = 0; i < intBuffer.capacity(); i++) {
            System.out.print(intBuffer.get(i)+" ");
        }
        System.out.println();
        ByteBuffer byteBuffer4 = ByteBuffer.allocate(32);
        byteBuffer4.putLong(41L);
        byteBuffer4.putLong(42L);
        byteBuffer4.putLong(43L);
        byteBuffer4.putLong(44L);
        byteBuffer4.flip();
        LongBuffer longBuffer = byteBuffer4.asLongBuffer();
        for (int i = 0; i < longBuffer.capacity(); i++) {
            System.out.print(longBuffer.get(i) + " ");
        }
        System.out.println();
        ByteBuffer byteBuffer5 = ByteBuffer.allocate(8);
        byteBuffer5.putShort((short) 51);
        byteBuffer5.putShort((short) 52);
        byteBuffer5.putShort((short) 53);
        byteBuffer5.putShort((short) 54);
        byteBuffer5.flip();
        ShortBuffer shortBuffer = byteBuffer5.asShortBuffer();
        for (int i = 0; i < shortBuffer.capacity(); i++) {
            System.out.print(shortBuffer.get(i) + " ");
        }
    }
}
