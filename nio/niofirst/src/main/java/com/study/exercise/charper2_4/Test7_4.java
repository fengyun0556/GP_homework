package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test7_4 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("e:/txt"));
        FileChannel fileChannel = fos.getChannel();
        System.out.println("A position="+fileChannel.position());
        fileChannel.position(3);
        System.out.println("B position="+fileChannel.position());
        fileChannel.write(ByteBuffer.wrap("abcde".getBytes()));
        System.out.println("C position="+fileChannel.position());
        fileChannel.close();
        fos.close();
    }
}
