package com.study.exercise.charper5_7.socketOption;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test7 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] byteArray = new byte[1024];
        int readLength = -1;
        while ((readLength = inputStream.read(byteArray)) != -1) {
            System.out.println(new String(byteArray, 0, readLength));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
