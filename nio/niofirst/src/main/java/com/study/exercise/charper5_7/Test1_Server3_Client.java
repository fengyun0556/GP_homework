package com.study.exercise.charper5_7;

import java.net.Socket;

public class Test1_Server3_Client {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Socket socket = new Socket("localhost", 8888);
            socket.close();
            System.out.println("client count = " + i);
        }
    }
}
