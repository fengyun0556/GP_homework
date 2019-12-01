package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test5_4 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        byte[] byteArrayOut = new byte[5];
        byteBuffer.get(byteArrayOut, 0 ,7);
    }
}
