package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fileA = new RandomAccessFile("e:/a.txt", "rw");
        FileChannel fileChannelA = fileA.getChannel();
        System.out.println("A begin");
        fileChannelA.lock(1,2,false);
        System.out.println("A end");
        Thread.sleep(Integer.MAX_VALUE);
        fileA.close();
        fileChannelA.close();
    }
}
