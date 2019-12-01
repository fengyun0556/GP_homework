package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1_3 {

    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fosRef = new FileOutputStream(new File("E:/a.txt"));
        fileChannel = fosRef.getChannel();

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(() -> {
                try {
                    ByteBuffer buffer = ByteBuffer.wrap("abcde\r\n".getBytes());
                    fileChannel.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    ByteBuffer buffer = ByteBuffer.wrap("我是中国人\r\n".getBytes());
                    fileChannel.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        fileChannel.close();
        fosRef.close();
    }



}
