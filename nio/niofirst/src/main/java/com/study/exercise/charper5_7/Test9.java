package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test9 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);
        Selector selector1 = Selector.open();
        Selector selector2 = Selector.open();
        System.out.println(selector1 == selector2);
        SelectionKey selectionKey1 = serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey1+" "+selectionKey1.hashCode());
        SelectionKey selectionKey2 = serverSocketChannel.register(selector2, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey2+" "+selectionKey2.hashCode());
        serverSocketChannel.close();
    }
}
