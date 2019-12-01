package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test4_1 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5};
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.position(1);
        buffer.put(byteArray);
        byte[] newByteArray = buffer.array();
        for (int i = 0; i < newByteArray.length; i++) {
            System.out.print(newByteArray[i]);
        }
    }
}
