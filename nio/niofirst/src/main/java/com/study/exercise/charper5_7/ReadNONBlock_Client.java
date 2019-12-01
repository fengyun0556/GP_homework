package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ReadNONBlock_Client {
    public static void main(String[] args) throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 7077));
        channel.close();
    }
}
