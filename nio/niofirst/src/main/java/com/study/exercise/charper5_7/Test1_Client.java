package com.study.exercise.charper5_7;

import java.io.OutputStream;
import java.net.Socket;

public class Test1_Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("client send data".getBytes());
        outputStream.close();
        socket.close();
    }
}
