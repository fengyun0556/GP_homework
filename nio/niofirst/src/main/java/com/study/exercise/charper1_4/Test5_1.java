package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test5_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put(byteArrayIn1, 0, byteBuffer.capacity()-3);
    }
}
