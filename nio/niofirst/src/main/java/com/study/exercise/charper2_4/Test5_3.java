package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test5_3 {
    private static FileOutputStream fos;
    private static FileChannel fileChannel;
    private static int count = 0;

    public synchronized static ByteBuffer[] getByteBufferArray(String printString1, String printString2){
        count++;
        ByteBuffer byteBuffer1 = ByteBuffer.wrap((printString1+count+"\r\n").getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap((printString2+count+"\r\n").getBytes());
        return new ByteBuffer[]{byteBuffer1, byteBuffer2};
    }

    public static void main(String[] args) throws Exception {
        fos = new FileOutputStream(new File("e:/a.txt"));
        fileChannel = fos.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(()->{
                try {
                    ByteBuffer[] bufferArray = getByteBufferArray("aaaa", "bbbb");
                    fileChannel.write(bufferArray, 0, 2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(()->{
                try {
                    ByteBuffer[] bufferArray = getByteBufferArray("xxxx", "yyyy");
                    fileChannel.write(bufferArray, 0, 2);
                } catch (IOException e) {
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
