package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test7_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
        System.out.println("A fileChannel.position="+fileChannel.position());
        fileChannel.write(buffer);
        System.out.println("B fileChannel.position="+fileChannel.position());
        buffer.rewind();
        fileChannel.write(buffer, 2);
        System.out.println("C fileChannel.position="+fileChannel.position());
        fileChannel.close();
        fos.close();
    }
}
