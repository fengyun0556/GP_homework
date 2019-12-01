package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test6_5 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File("e:a.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        System.out.println("A "+fileChannel.position());
        long readLength = fileChannel.read(bufferArray, 0 ,2);
        System.out.println("B "+fileChannel.position()+",length="+readLength);
        fileChannel.close();
        fileInputStream.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();
        for (int i = 0; i < bufferArray.length; i++) {
            ByteBuffer eachBuffer = bufferArray[i];
            byte[] byteArray = eachBuffer.array();
            System.out.println(new String(byteArray));
        }
    }
}
