package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_5 {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        System.out.println("A "+ fileChannel.position());
        fileChannel.read(byteBuffer);
        System.out.println("B "+ fileChannel.position());
        fileChannel.close();
        fis.close();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }

    }
}
