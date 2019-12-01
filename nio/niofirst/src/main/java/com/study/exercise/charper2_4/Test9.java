package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test9 {
    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcd".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("cde".getBytes());
        FileOutputStream fos = new FileOutputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        System.out.println("A position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.write(byteBuffer1);
        System.out.println("B position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.position(2);
        System.out.println("C position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.write(byteBuffer2);
        System.out.println("D position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.close();
        fos.flush();
        fos.close();
    }
}
