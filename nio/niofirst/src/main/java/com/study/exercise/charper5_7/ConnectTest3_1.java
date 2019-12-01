package com.study.exercise.charper5_7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest3_1 {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            System.out.println(socketChannel.isConnectionPending());
            socketChannel.connect(new InetSocketAddress("192.168.0.123", 9090));
            System.out.println(socketChannel.isConnectionPending());
            socketChannel.close();
        } catch (IOException e){
            e.printStackTrace();
            System.err.println(socketChannel.isConnectionPending());
        }
    }
}
