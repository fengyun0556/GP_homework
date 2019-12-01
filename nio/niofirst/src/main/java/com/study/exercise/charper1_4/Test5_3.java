package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test5_3 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int getArrayIndex = 0;
        while (getArrayIndex < byteArrayIn1.length) {
            int readLength = Math.min(byteBuffer.remaining(), byteArrayIn1.length - getArrayIndex);
            byteBuffer.put(byteArrayIn1, getArrayIndex, readLength);
            byteBuffer.flip();
            byte[] getArray = byteBuffer.array();
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.print(getArray[i] + " ");
            }
            getArrayIndex = getArrayIndex + readLength;
            System.out.println();
            byteBuffer.clear();
        }
    }
}
