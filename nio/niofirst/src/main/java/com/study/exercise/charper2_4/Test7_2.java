package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test7_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
        fileChannel.write(buffer1);
        buffer2.position(1);
        buffer2.limit(3);
        fileChannel.write(buffer2, 2);
        System.out.println(fileChannel.position());
        fileChannel.close();
        fos.close();
    }
}
