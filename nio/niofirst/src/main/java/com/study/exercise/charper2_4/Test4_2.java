package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test4_2 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        fileChannel.position(2);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        fileChannel.read(bufferArray);
        for (int i = 0; i < bufferArray.length; i++) {
            byte[] getByte = bufferArray[i].array();
            for (int j = 0; j < getByte.length; j++) {
                System.out.print((char)getByte[j]);
            }
            System.out.println();
        }
        fileChannel.close();
        fis.close();
    }
}
