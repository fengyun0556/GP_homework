package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test4_3 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        byte[] byteArrayNew = new byte[5];
        buffer.get(byteArrayNew);
        for (int i = 0; i < byteArrayNew.length; i++) {
            System.out.print(byteArrayNew[i]);
        }
    }
}
