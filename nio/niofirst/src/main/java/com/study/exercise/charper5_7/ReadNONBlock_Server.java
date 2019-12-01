package com.study.exercise.charper5_7;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ReadNONBlock_Server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel channel1 = ServerSocketChannel.open();
        channel1.configureBlocking(false);
        channel1.bind(new InetSocketAddress("localhost", 7077));
        Selector selector = Selector.open();
        channel1.register(selector, SelectionKey.OP_ACCEPT);
        selector.select();
        Set<SelectionKey> selectionKeySet = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeySet.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            System.out.println("begin "+System.currentTimeMillis());
            socketChannel.read(byteBuffer);
            System.out.println("end " + System.currentTimeMillis()+" byteBuffer.position="+byteBuffer.position());
            channel1.close();
        }
    }
}
