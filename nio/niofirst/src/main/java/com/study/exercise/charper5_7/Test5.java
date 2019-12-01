package com.study.exercise.charper5_7;

import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;

public class Test5 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println(serverSocketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
        serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 5678);
        System.out.println(serverSocketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
        serverSocketChannel.close();
    }
}
