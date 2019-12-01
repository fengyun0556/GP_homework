package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test6_4 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(() -> {
                try {
                    ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                    ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                    ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
                    long readLength = fileChannel.read(bufferArray, 0, 2);
                    while (readLength != -1){
                        synchronized (Test6_4.class){
                            for (int j = 0; j < bufferArray.length; j++) {
                                byte[] getByte = bufferArray[j].array();
                                System.out.print(new String(getByte));
                            }
                        }
                        byteBuffer1.clear();
                        byteBuffer2.clear();
                        readLength = fileChannel.read(bufferArray, 0 ,2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(() -> {
                try {
                    ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                    ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                    ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
                    long readLength = fileChannel.read(bufferArray, 0, 2);
                    while (readLength != -1){
                        synchronized (Test6_4.class){
                            for (int j = 0; j < bufferArray.length; j++) {
                                byte[] getByte = bufferArray[j].array();
                                System.out.print(new String(getByte));
                            }
                        }
                        byteBuffer1.clear();
                        byteBuffer2.clear();
                        readLength = fileChannel.read(bufferArray, 0 ,2);
                    }
                } catch (IOException e) {
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
