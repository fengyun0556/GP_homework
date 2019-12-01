package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestBlockServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println(serverSocketChannel.isBlocking());
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        System.out.println("begin = " + System.currentTimeMillis());
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("end = " + System.currentTimeMillis());
        socketChannel.close();
        serverSocketChannel.close();
    }
}
