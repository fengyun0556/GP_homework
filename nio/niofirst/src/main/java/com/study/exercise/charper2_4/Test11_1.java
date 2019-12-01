package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fileA = new RandomAccessFile("e:/a.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("e:/b.txt", "rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        fileChannel2.position(7);
        fileChannel1.transferTo(4, 4, fileChannel2);
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();
    }
}
