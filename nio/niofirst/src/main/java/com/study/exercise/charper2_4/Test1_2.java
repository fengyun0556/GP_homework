package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1_2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fosRef = new FileOutputStream(new File("E:/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        try {
            ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
            ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
            fileChannel.write(buffer1);
            buffer2.position(1);
            buffer2.limit(3);
            fileChannel.position(2);
            fileChannel.write(buffer2);
        } catch (Exception e){
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();
    }
}
