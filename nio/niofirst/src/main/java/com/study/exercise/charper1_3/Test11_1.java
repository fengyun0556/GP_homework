package com.study.exercise.charper1_3;

import java.nio.CharBuffer;

public class Test11_1 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(20);
        System.out.println("A.position="+charBuffer.position()+" limit="+charBuffer.limit());
        charBuffer.put("我是中国人我在中华人民共和国");
        System.out.println("B.position="+charBuffer.position()+" limit="+charBuffer.limit());
        charBuffer.position(0);
        System.out.println("C.position="+charBuffer.position()+" limit="+charBuffer.limit());
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get());
        }
        System.out.println();
        System.out.println("D.position="+charBuffer.position()+" limit="+charBuffer.limit());
        charBuffer.clear();
        System.out.println("E.position="+charBuffer.position()+" limit="+charBuffer.limit());
        charBuffer.put("我是美国人");
        System.out.println("F.position="+charBuffer.position()+" limit="+charBuffer.limit());
        charBuffer.limit(charBuffer.position());
        charBuffer.position(0);
        System.out.println("G.position="+charBuffer.position()+" limit="+charBuffer.limit());
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get());
        }
    }
}
