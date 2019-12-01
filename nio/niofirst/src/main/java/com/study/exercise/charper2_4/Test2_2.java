package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_2 {
    private static FileInputStream fis;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fis = new FileInputStream(new File("e:/a.txt"));
        fileChannel = fis.getChannel();
        fileChannel.position(2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        fileChannel.read(byteBuffer);
        byte[] getByteArray = byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++) {
            System.out.print((char)getByteArray[i]);
        }
        fileChannel.close();
        fis.close();
    }
}
