package com.study.exercise.charper1_3.test;

import java.nio.ByteBuffer;

public class Test1_2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.limit(-1);
    }
}
