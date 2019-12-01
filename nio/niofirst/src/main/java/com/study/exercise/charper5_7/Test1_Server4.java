package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test1_Server4 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        int readLength = 0;
        while ((readLength = socketChannel.read(byteBuffer)) != -1){
            String newString = new String(byteBuffer.array());
            System.out.println(newString);
            byteBuffer.flip();
        }
        socketChannel.close();
        serverSocketChannel.close();
    }
}
