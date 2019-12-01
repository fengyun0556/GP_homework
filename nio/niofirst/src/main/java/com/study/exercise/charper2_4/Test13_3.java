package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_3 {
    private static FileOutputStream fileA;
    private static FileChannel fileChannelA;

    public static void main(String[] args) throws Exception {
        fileA = new FileOutputStream(new File("e:/a.txt"));
        fileChannelA = fileA.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.wrap("123456".getBytes());
        fileChannelA.write(byteBuffer);
        fileA.flush();

        Thread a = new Thread(()->{
            try {
                fileChannelA.lock(1,2,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(()->{
            try {
                fileChannelA.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(2000);

        fileA.close();
        fileChannelA.close();
    }
}
