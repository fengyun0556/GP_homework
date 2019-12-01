package com.study.exercise.charper5_8;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test10 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println(1);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        System.out.println(2);
        serverSocketChannel.configureBlocking(false);
        System.out.println(3);
        Selector selector1 = Selector.open();
        System.out.println(4);
        SelectionKey selectionKey1 = serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT);
        System.out.println(5);

        int keyCount = selector1.select();
        System.out.println("6 keyCount = "+keyCount);
        serverSocketChannel.close();
        System.out.println("7 end");
    }
}
