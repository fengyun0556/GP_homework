package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test17_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn = {1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn);
        System.out.println(byteBuffer.equals(byteBuffer));
    }
}
