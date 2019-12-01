package com.study.exercise.charper1_4;

import java.nio.ByteBuffer;

public class Test3 {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        System.out.println("A1 capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        buffer1.put((byte) 123);
        System.out.println("A2 capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        buffer1.put((byte) 126);
        System.out.println("A3 capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        buffer1.put((byte) 127);
        System.out.println("B capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        buffer1.rewind();
        System.out.println("C capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        System.out.println(buffer1.get());
        System.out.println("D capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        System.out.println(buffer1.get());
        System.out.println("E capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        System.out.println(buffer1.get());
        System.out.println("F capacity="+buffer1.capacity()+",limit="+buffer1.limit()+",position="+buffer1.position()+",offset="+buffer1.arrayOffset());
        System.out.println(buffer1.get());
        byte[] getByteArray = buffer1.array();
        for (int i = 0; i < getByteArray.length; i++) {
            System.out.print(getByteArray[i]+"-");
        }
    }
}
