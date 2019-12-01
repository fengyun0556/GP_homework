package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test4 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{3,4,5,6,7,8};
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        System.out.println("A="+buffer.position());
        buffer.put(byteArray);
        System.out.println("B="+buffer.position());
        buffer.flip();
        buffer.position(3);
        System.out.println("C="+buffer.position());
        byte[] newArray = new byte[buffer.remaining()];
        buffer.get(newArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
