package com.study.exercise.charper2_4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test8_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fos = new FileInputStream(new File("e:/a.txt"));
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byteBuffer.position(3);
        fileChannel.read(byteBuffer, 2);
        byte[] getByteArray = byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++) {
            if (getByteArray[i] == 0){
                System.out.print("空格");
            } else {
                System.out.print((char)getByteArray[i]);
            }
        }
        System.out.println();

        fileChannel.close();
        fos.close();
    }
}
