package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test1_3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocateDirect(600000000);
        for (int i = 0; i < 600000000; i++) {
            buffer.put((byte) 123);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
