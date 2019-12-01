package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Test4_5 {
    public static void main(String[] args) {
        byte[] byteArray = {1,2,3,4,5,6,7,8,9,10};
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        int byteArrayCurrentIndex = 0;
        int byteArrayRemaining = 0;
        while (byteArrayCurrentIndex < byteArray.length){
            byteArrayRemaining = byteArray.length - byteArrayCurrentIndex;
            int readLength = Math.min(byteArrayRemaining, byteBuffer.remaining());
            byte[] newByteArray = Arrays.copyOfRange(byteArray, byteArrayCurrentIndex, byteArrayCurrentIndex+readLength);
            byteBuffer.put(newByteArray);
            byteBuffer.flip();
            byte[] getByte = byteBuffer.array();
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.print(getByte[i] + " ");
            }
            System.out.println();
            byteArrayCurrentIndex += readLength;
            byteBuffer.clear();
        }
    }
}
