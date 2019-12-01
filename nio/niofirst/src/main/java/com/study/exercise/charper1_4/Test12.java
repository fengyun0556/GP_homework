package com.study.exercise.charper1_4;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Test12 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] byteArrayIn1 = "我是中国人".getBytes("utf-8");
        System.out.println(Charset.defaultCharset().name());
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        CharBuffer charBuffer = Charset.forName("utf-8").decode(byteBuffer);
        System.out.println("byteBuffer="+byteBuffer.getClass().getName());
        System.out.println("charBuffer="+charBuffer.getClass().getName());
        System.out.println("byteBuffer.position="+byteBuffer.position()+
                ",byteBuffer.capacity="+byteBuffer.capacity()+
                ",byteBuffer.limit="+byteBuffer.limit());
        System.out.println("charBuffer.position="+charBuffer.position()+
                ",charBuffer.capacity="+charBuffer.capacity()+
                ",charBuffer.limit="+charBuffer.limit());
        charBuffer.position(0);
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get()+ " ");
        }
    }
}
