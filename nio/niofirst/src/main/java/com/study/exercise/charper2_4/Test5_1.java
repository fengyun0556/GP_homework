package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test5_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("12345".getBytes());
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        fileChannel.write(ByteBuffer.wrap("qqqqq".getBytes()));
        fileChannel.position(2);
        fileChannel.write(bufferArray, 0, 2);
        fileChannel.close();
        fos.close();
    }
}
