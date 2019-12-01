package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test16 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(new byte[]{1,2,3,4,5,6});
        System.out.println("A capacity="+byteBuffer1.capacity()+",position="+byteBuffer1.position()+",limit="+byteBuffer1.limit());
        System.out.println("1 getValue="+byteBuffer1.get());
        System.out.println("B capacity="+byteBuffer1.capacity()+",position="+byteBuffer1.position()+",limit="+byteBuffer1.limit());
        System.out.println("2 getValue="+byteBuffer1.get());
        System.out.println("C capacity="+byteBuffer1.capacity()+",position="+byteBuffer1.position()+",limit="+byteBuffer1.limit());
        byteBuffer1.compact();
        System.out.println("byteBuffer1.compact()");
        System.out.println("D capacity="+byteBuffer1.capacity()+",position="+byteBuffer1.position()+",limit="+byteBuffer1.limit());
        byte[] getByteArray = byteBuffer1.array();
        for (int i = 0; i < getByteArray.length; i++) {
            System.out.print(getByteArray[i]+" ");
        }
    }
}
