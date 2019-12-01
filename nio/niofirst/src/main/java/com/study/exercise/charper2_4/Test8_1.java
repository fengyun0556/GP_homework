package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test8_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream fos = new FileInputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        int readLength = fileChannel.read(byteBuffer, 2);
        System.out.println(readLength);
        byteBuffer.clear();
        readLength = fileChannel.read(byteBuffer, 5);
        System.out.println(readLength);
        fileChannel.close();
        fos.close();
    }
}
