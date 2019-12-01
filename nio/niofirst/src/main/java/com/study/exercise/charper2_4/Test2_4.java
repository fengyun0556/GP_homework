package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_4 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        for (int i = 0; i < 1; i++) {
            Thread thread1 = new Thread(() -> {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                    int readLength = fileChannel.read(byteBuffer);
                    while (readLength != -1){
                        byte[] getByte = byteBuffer.array();
                        System.out.println(new String(getByte, 0 , readLength));
                        byteBuffer.clear();
                        readLength = fileChannel.read(byteBuffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread thread2 = new Thread(()->{
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                    int readLength = fileChannel.read(byteBuffer);
                    while (readLength != -1){
                        byte[] getByte = byteBuffer.array();
                        System.out.println(new String(getByte, 0 , readLength));
                        byteBuffer.clear();
                        readLength = fileChannel.read(byteBuffer);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        fileChannel.close();
        fis.close();
    }
}
