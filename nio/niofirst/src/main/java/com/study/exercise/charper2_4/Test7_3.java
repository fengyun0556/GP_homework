package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test7_3 {
    private static FileOutputStream fos;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fos = new FileOutputStream(new File("e:/a.txt"));
        fileChannel = fos.getChannel();
        Thread thread1 = new Thread(()->{
            try {
                System.out.println("线程1运行");
                ByteBuffer buffer = ByteBuffer.wrap("12345".getBytes());
                fileChannel.write(buffer, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("线程2运行");
                ByteBuffer buffer = ByteBuffer.wrap("67890".getBytes());
                fileChannel.write(buffer, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        thread1.start();

        Thread.sleep(3000);
        fileChannel.close();
        fos.close();
    }
}
