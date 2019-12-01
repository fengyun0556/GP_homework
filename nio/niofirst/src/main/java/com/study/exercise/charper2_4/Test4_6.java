package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test4_6 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(7);
        byteBuffer1.position(1);
        byteBuffer1.limit(3);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(7);
        byteBuffer2.position(2);
        byteBuffer2.limit(4);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        fileChannel.read(bufferArray);
        fileChannel.close();
        fileInputStream.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();
        for (int i = 0; i < bufferArray.length; i++) {
            ByteBuffer eachBuffer = bufferArray[i];
            byte[] byteArray = eachBuffer.array();
            for (int j = 0; j < byteArray.length; j++) {
                byte eachByte = byteArray[j];
                if (eachByte == 0){
                    System.out.print("空格");
                } else {
                    System.out.print((char) byteArray[j]);
                }
            }
            System.out.println();
        }
    }
}
