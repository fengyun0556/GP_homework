package com.study.exercise.charper2_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_5_2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            try {
                RandomAccessFile file1 = new RandomAccessFile("e:/a.txt", "rw");
                FileChannel fileChannel = file1.getChannel();
                System.out.println("B begin");
                fileChannel.lock(0, 2, false);
                System.out.println("B end");
                fileChannel.close();
                file1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(2000);
    }
}
