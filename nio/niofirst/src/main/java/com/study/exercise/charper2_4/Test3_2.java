package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test3_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.position(3);
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("uvwxy2".getBytes());
        ByteBuffer[] bufferArray = new ByteBuffer[]{buffer1, buffer2};
        buffer1.position(1);
        buffer1.limit(3);
        buffer2.position(2);
        buffer2.limit(4);
        fileChannel.write(bufferArray);
        fileChannel.close();
        fos.close();
    }
}
