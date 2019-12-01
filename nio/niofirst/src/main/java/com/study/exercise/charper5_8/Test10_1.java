package com.study.exercise.charper5_8;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class Test10_1 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);
        Selector selector1 = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            int keyCount = selector1.select();
            Set<SelectionKey> set1 = selector1.keys();
            Set<SelectionKey> set2 = selector1.selectedKeys();
            System.out.println("keyCount="+keyCount);
            System.out.println("set1.size="+set1.size());
            System.out.println("set2.size="+set2.size());
            System.out.println();
        }
        serverSocketChannel.close();
    }
}
