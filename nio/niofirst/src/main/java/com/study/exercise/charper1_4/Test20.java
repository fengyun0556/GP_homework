package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test20 {
    public static void main(String[] args) {
        byte[]  byteArrayIn1 = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = extendsSize(byteBuffer1, 2);
        byte[] newArray = byteBuffer2.array();
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    private static ByteBuffer extendsSize(ByteBuffer buffer, int extendsSize){
        ByteBuffer newByteBuffer = ByteBuffer.allocate(buffer.capacity()+extendsSize);
        newByteBuffer.put(buffer);
        return newByteBuffer;
    }

}
