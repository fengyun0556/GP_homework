package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test2 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println("serverSocketChannel.isBlocking="+serverSocketChannel.isBlocking());
        serverSocketChannel.configureBlocking(false);
        System.out.println("serverSocketChannel.isBlocking="+serverSocketChannel.isBlocking());
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost", 8888));
        Selector selector = Selector.open();
        System.out.println("serverSocketChannel.isRegistered="+serverSocketChannel.isRegistered());
        SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("serverSocketChannel.isRegistered="+serverSocketChannel.isRegistered());
        System.out.println("selector = " + selector);
        System.out.println("key = "+key);
        serverSocket.close();
        serverSocketChannel.close();
    }
}
