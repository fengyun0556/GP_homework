package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest3_3 {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        System.out.println(socketChannel.isConnectionPending());
        socketChannel.connect(new InetSocketAddress("localhost", 8888));
        System.out.println(socketChannel.isConnectionPending());
        socketChannel.close();
    }
}
