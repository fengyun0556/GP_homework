package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_1 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        int readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);

        readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);
        byteBuffer.clear();
        readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);
        byteBuffer.clear();
        fileChannel.close();
        fis.close();
    }
}
