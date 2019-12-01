package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test4_1 {

    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        long readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();
        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();
        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();
        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();
        fileChannel.close();
        fis.close();
    }
}
