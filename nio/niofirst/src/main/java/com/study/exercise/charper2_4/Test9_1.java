package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test9_1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("e:/a.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        System.out.println("A position="+fileChannel.position()+" size="+fileChannel.size());
        System.out.println(fileChannel.read(ByteBuffer.allocate(10), 10000));
        fileChannel.position(9);
        System.out.println("B position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("z".getBytes()));
        System.out.println("C position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.close();
    }
}
