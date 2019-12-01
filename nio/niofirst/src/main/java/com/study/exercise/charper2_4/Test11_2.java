package com.study.exercise.charper2_4;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_2 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fileA = new RandomAccessFile("e:/a.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("e:/b.txt", "rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        fileChannel2.position(3);
        fileChannel1.transferTo(2, 3, fileChannel2);
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();
    }
}
