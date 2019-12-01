package com.study.exercise.charper1_5;

import java.io.IOException;
import java.nio.CharBuffer;

public class Test3 {
    public static void main(String[] args) throws IOException {
        CharBuffer buffer1 = CharBuffer.allocate(8);
        buffer1.append("ab123456");
        buffer1.position(2);
        buffer1.put("cde");
        buffer1.rewind();
        for (int i = 0; i < buffer1.limit(); i++) {
            System.out.print(buffer1.get());
        }
        System.out.println();
        buffer1.position(1);
        CharBuffer buffer2 = CharBuffer.allocate(4);
        System.out.println("A buffer2.position=" + buffer2.position());
        buffer1.read(buffer2);
        System.out.println("B buffer2.position=" + buffer2.position());
        buffer2.rewind();
        for (int i = 0; i < buffer2.limit(); i++) {
            System.out.print(buffer2.get());
        }
        System.out.println();
        buffer1.position(2);
        CharBuffer buffer3 = buffer1.subSequence(0, 2);
        System.out.println("C buffer3.position=" + buffer3.position() + ",capacity" + buffer3.capacity()
                + ",limit=" + buffer3.limit());
        for (int i = buffer3.position(); i < buffer3.limit(); i++) {
            System.out.print(buffer3.get());
        }

    }
}
