package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test6_3 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
        byteBuffer1.position(3);
        byteBuffer2.position(4);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        fileChannel.read(bufferArray, 0, 2);
        for (int i = 0; i < bufferArray.length; i++) {
            ByteBuffer eachByteBuffer = bufferArray[i];
            byte[] getByteArray = eachByteBuffer.array();
            for (int j = 0; j < getByteArray.length; j++) {
                if (getByteArray[j] == 0){
                    System.out.print("空格");
                } else {
                    System.out.print((char)getByteArray[j]);
                }
            }
            System.out.println();
        }
        fileChannel.close();
        fis.close();
    }
}
