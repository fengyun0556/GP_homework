package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test7 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey1+" "+ selectionKey1.hashCode());
        SelectionKey selectionKey2 = serverSocketChannel.keyFor(selector);
        System.out.println(selectionKey2+" "+ selectionKey2.hashCode());
        System.out.println(selectionKey1 == selectionKey2);
    }
}
