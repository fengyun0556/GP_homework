package com.study.exercise.charper4_1.test7;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println(serverSocket.getSoTimeout());
        serverSocket.setSoTimeout(4000);
        System.out.println(serverSocket.getSoTimeout());
        System.out.println();
        System.out.println("start = "+System.currentTimeMillis());
        serverSocket.accept();
        System.out.println("end = "+System.currentTimeMillis());
    }
}
