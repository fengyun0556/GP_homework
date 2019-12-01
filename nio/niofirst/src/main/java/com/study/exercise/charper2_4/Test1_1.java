package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1_1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fosRef = new FileOutputStream(new File("E:/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        try {
            ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
            System.out.println("A fileChannel.position="+fileChannel.position());
            System.out.println("write() 1 return value:"+fileChannel.write(buffer));
            System.out.println("B fileChannel.position="+fileChannel.position());
            fileChannel.position(2);
            buffer.rewind();
            System.out.println("write() 2 return value:"+fileChannel.write(buffer));
            System.out.println("C fileChannel.position="+fileChannel.position());
        } catch (Exception e){
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();
    }
}
