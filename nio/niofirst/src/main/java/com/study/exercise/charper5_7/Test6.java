package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class Test6 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        InetSocketAddress address = (InetSocketAddress) serverSocketChannel.getLocalAddress();
        System.out.println(address.getHostString());
        System.out.println(address.getPort());
        serverSocketChannel.close();
    }
}
