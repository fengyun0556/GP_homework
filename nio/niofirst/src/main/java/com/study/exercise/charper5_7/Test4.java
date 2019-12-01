package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(2000);
                Socket socket = new Socket("localhost", 8088);
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));
        SocketChannel socketChannel = serverSocketChannel.accept();

        Set<SocketOption<?>> set1 = serverSocketChannel.supportedOptions();
        Set<SocketOption<?>> set2 = socketChannel.supportedOptions();

        System.out.println("serverSocketChannel.supportedOptions:");
        for (SocketOption socketOption : set1) {
            System.out.println(socketOption.getClass().getName());
        }
        System.out.println("\n\n");
        for (SocketOption socketOption : set2) {
            System.out.println(socketOption.getClass().getName());
        }

        socketChannel.close();
        serverSocketChannel.close();
    }
}
