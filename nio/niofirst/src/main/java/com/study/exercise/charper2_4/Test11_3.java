package com.study.exercise.charper2_4;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_3 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file1 = new RandomAccessFile("e:/a.txt", "rw");
        RandomAccessFile file2 = new RandomAccessFile("e:/b.txt", "rw");
        FileChannel fileChannel1 = file1.getChannel();
        FileChannel fileChannel2 = file2.getChannel();
        System.out.println("A position="+fileChannel2.position());
        fileChannel1.transferTo(0, 1000, fileChannel2);
        System.out.println("B position="+fileChannel1.position());
        fileChannel1.close();
        fileChannel2.close();
        file1.close();
        file2.close();
    }
}
