package com.study.exercise.charper5_7;

import sun.security.krb5.EncryptedData;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest1 {
    public static void main(String[] args) {
        long beginTime = 0;
        long endTime = 0;
        boolean connectResult = false;
        try {
            SocketChannel socketChannel = SocketChannel.open();
            beginTime = System.currentTimeMillis();
            connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));
            endTime = System.currentTimeMillis();
            System.out.println("connect cost time = " + (endTime - beginTime) + ",connectResult = " + connectResult);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
            endTime = System.currentTimeMillis();
            System.err.println("connect cost time = " + (endTime - beginTime) + ",connectResult = " + connectResult);
        }


    }
}
