package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test15 {
    public static void main(String[] args) {
        byte[] byteArrayIn = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn);
        ByteBuffer byteBuffer2 = byteBuffer1.asReadOnlyBuffer();
        System.out.println("byteBuffer1.isReadOnly = "+byteBuffer1.isReadOnly());
        System.out.println("byteBuffer2.isReadOnly = "+byteBuffer2.isReadOnly());
        byteBuffer2.rewind();
//        byteBuffer2.put((byte) 123);
        byteBuffer1.put(1, (byte) 9);

        for (int i = 0; i < byteBuffer2.limit(); i++) {
            System.out.print(byteBuffer2.get()+" ");
        }
    }
}
