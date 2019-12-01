package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test17_2 {
    public static void main(String[] args) {
        byte[] byteArrayIn = {1,2,3,4,5};
        int[] intArrayIn = {1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn);
        IntBuffer intBuffer = IntBuffer.wrap(intArrayIn);
        System.out.println(byteBuffer.equals(intBuffer));
    }
}
