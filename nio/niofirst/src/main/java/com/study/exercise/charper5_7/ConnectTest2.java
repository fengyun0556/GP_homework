package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest2 {
    public static void main(String[] args) throws Exception {
        long beginTime = 0;
        long endTime = 0;
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        beginTime = System.currentTimeMillis();
        System.out.println(socketChannel.isConnectionPending());
        boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));
        endTime = System.currentTimeMillis();
        System.out.println("connect cost time = " + (endTime - beginTime) + ",connectResult = " + connectResult);
        Thread.sleep(1000);
        System.out.println(socketChannel.isConnectionPending());
        socketChannel.close();
    }
}
