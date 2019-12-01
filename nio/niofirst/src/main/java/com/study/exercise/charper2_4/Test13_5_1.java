package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_5_1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file1 = new RandomAccessFile("e:/a.txt", "rw");
        FileChannel fileChannel = file1.getChannel();
        System.out.println("A begin");
        fileChannel.lock(0, 2, false);
        System.out.println("A end");
        Thread.sleep(20000);
        fileChannel.close();
        file1.close();
    }
}
