package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test5_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("12345".getBytes());
        byteBuffer2.position(1);
        byteBuffer2.limit(3);
        ByteBuffer byteBuffer3 = ByteBuffer.wrap("d1e1f1".getBytes());
        byteBuffer3.position(2);
        byteBuffer3.limit(4);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3};
        fileChannel.write(bufferArray, 2, 1);
        fileChannel.close();
        fos.close();
    }
}
