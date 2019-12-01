package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ConnectTest4_2 {
    public static void main(String[] args) throws Exception {
        long beginTime = 0;
        long endTime = 0;
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));
        Thread t = new Thread(()->{
            try {
                Thread.sleep(50);
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
                SocketChannel socketChannel1 = serverSocketChannel.accept();
                socketChannel1.close();
                serverSocketChannel.close();
                System.out.println("server end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
        if (!connectResult){
            System.out.println("connectResult == false");
            while (!socketChannel.finishConnect()){
                System.out.println("try to connect");
            }
        }
        socketChannel.close();
    }
}
