package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_6 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.position(1);
        byteBuffer.limit(3);
        fileChannel.read(byteBuffer);
        fileChannel.close();
        fis.close();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            byte eachByte = byteBuffer.get();
            if (eachByte == 0){
                System.out.print("空格");
            } else {
                System.out.print((char)eachByte);
            }
        }
    }
}
