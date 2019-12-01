package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest4_1 {
    public static void main(String[] args) throws Exception {
        long beginTime = 0;
        long endTime = 0;
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connectionResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));
        if (!connectionResult){
            System.out.println("connectionResult == false");
            while (!socketChannel.finishConnect()){
                System.out.println("try to connect");
            }
        }
        socketChannel.close();
    }
}
