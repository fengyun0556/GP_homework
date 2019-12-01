package com.study.exercise.charper4_4.udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.connect(new InetSocketAddress("localhost", 8080));
        String newString = "12345678901";
        byte[] byteArray = newString.getBytes();
        DatagramPacket myPacket = new DatagramPacket(byteArray, byteArray.length);
        datagramSocket.send(myPacket);
        datagramSocket.close();
    }
}
