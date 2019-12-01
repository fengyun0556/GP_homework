package com.study.exercise.charper5_7.socketOption;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.StandardOpenOption;

public class Test8 {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1234);
        socketChannel.connect(new InetSocketAddress("localhost", 8088));
        socketChannel.write(ByteBuffer.wrap("i come from client".getBytes()));
        socketChannel.close();
    }
}
