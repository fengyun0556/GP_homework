package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Test1_Server3 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888), 60);
//        ServerSocket serverSocket = serverSocketChannel.socket();
        ServerSocket serverSocket = new ServerSocket(8888, 60);
        Thread.sleep(5000);
        boolean isRun = true;
        while (isRun) {
            Socket socket = serverSocket.accept();
            Thread.sleep(2000);
            socket.close();
        }
        Thread.sleep(8000);
        serverSocket.close();
        serverSocketChannel.close();
    }
}
