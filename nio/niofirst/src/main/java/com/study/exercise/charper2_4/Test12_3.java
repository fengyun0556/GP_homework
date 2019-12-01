package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12_3 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fileA = new RandomAccessFile("e:/a.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("e:/b.txt", "rw");
        FileChannel fileChannelA = fileA.getChannel();
        FileChannel fileChannelB = fileB.getChannel();
        fileChannelB.position(2);
        long readLength = fileChannelA.transferFrom(fileChannelB, 1, 200);
        System.out.println(readLength);
        fileChannelA.close();
        fileChannelB.close();
        fileA.close();
        fileB.close();

    }
}
