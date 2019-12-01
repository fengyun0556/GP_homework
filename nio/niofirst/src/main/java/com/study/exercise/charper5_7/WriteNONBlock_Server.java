package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class WriteNONBlock_Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("localhost", 7077));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        selector.select();
        Set<SelectionKey> selectionKeySet = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeySet.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE/10);
            System.out.println("byteBuffer.limit="+byteBuffer.limit());
            System.out.println("begin "+System.currentTimeMillis());
            socketChannel.write(byteBuffer);
            System.out.println("end "+System.currentTimeMillis()+" byteBuffer.position="+byteBuffer.position());
        }
        channel.close();
    }
}
