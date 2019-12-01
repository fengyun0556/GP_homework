package com.study.exercise.charper4_1.test2;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("server start");
        socket.accept();
        System.out.println("server end");
        socket.close();
    }
}
