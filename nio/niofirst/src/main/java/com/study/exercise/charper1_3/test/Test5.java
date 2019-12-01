package com.study.exercise.charper1_3.test;

import java.nio.ByteBuffer;

public class Test5 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.mark();
        byteBuffer.reset();
    }
}
