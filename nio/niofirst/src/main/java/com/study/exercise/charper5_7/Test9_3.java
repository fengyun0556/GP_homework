package com.study.exercise.charper5_7;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test9_3 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(key1 == key2);
        serverSocketChannel.close();
    }
}
