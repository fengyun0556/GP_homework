package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test3_3 {

    private static FileOutputStream fos;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fos = new FileOutputStream(new File("e:/a.txt"));
        fileChannel = fos.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(()->{
                try {
                    ByteBuffer buffer1 = ByteBuffer.wrap("000001\r\n".getBytes());
                    ByteBuffer buffer2 = ByteBuffer.wrap("000002\r\n".getBytes());
                    ByteBuffer[] bufferArray = new ByteBuffer[]{buffer1, buffer2};
                    fileChannel.write(bufferArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(()->{
                try {
                    ByteBuffer buffer1 = ByteBuffer.wrap("zzzzz1\r\n".getBytes());
                    ByteBuffer buffer2 = ByteBuffer.wrap("zzzzz2\r\n".getBytes());
                    ByteBuffer[] bufferArray = new ByteBuffer[]{buffer1, buffer2};
                    fileChannel.write(bufferArray);
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
            thread1.start();
            thread2.start();
        }
        Thread.sleep(3000);
        fileChannel.close();
        fos.close();
    }
}
