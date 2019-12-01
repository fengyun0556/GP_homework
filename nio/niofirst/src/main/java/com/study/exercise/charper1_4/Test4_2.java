package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test4_2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{3,4,5,6,7,8};
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.position(8);
        buffer.put(byteArray);
    }
}
