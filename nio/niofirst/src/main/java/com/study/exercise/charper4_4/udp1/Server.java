package com.study.exercise.charper4_4.udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] byteArray = new byte[12];
        DatagramPacket myPacket = new DatagramPacket(byteArray, 10);
        datagramSocket.receive(myPacket);
        datagramSocket.close();
        System.out.println("包中数据的长度：" + myPacket.getLength());
        System.out.println(new String(myPacket.getData(), 0, myPacket.getLength()));
    }
}
