package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test3_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.position(3);
        ByteBuffer buffer1 = ByteBuffer.wrap("000001".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("000002".getBytes());
        ByteBuffer[] bufferArray = new ByteBuffer[]{buffer1, buffer2};
        fileChannel.write(bufferArray);
        fileChannel.close();
        fos.close();
    }
}
