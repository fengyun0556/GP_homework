package com.study.exercise.charper5_7;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test9_1 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.configureBlocking(false);
        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key1 = serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(key1 == key2);
        serverSocketChannel1.close();
        serverSocketChannel2.close();
    }
}
