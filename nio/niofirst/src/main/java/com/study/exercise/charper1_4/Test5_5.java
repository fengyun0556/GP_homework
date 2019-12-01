package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test5_5 {
    public static void main(String[] args) {
        byte[] byteArray = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(5);
        byte[] byteArrayOut = new byte[500];
        byteBuffer.get(byteArrayOut, 0, 50);
    }
}
