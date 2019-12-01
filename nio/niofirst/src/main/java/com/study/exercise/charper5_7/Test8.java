package com.study.exercise.charper5_7;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class Test8 {
    public static void main(String[] args) throws Exception {
        SelectorProvider provider1 = SelectorProvider.provider();
        System.out.println(provider1);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SelectorProvider provider2 = serverSocketChannel.provider();
        System.out.println(provider2);
        serverSocketChannel.close();
    }
}
