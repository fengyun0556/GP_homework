package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test4_4 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5};
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        buffer.position(3);
        byte[] byteArrayNew = new byte[3];
        buffer.get(byteArrayNew);
    }
}
