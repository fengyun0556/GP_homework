package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test10 {
    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("12345678".getBytes());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.write(byteBuffer1);
        System.out.println("A size="+fileChannel.size()+" position="+fileChannel.position());
        fileChannel.truncate(3);
        System.out.println("B size="+fileChannel.size()+" position="+fileChannel.position());
        fileChannel.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
