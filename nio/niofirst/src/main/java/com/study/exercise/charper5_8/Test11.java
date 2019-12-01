package com.study.exercise.charper5_8;

import java.net.Socket;

public class Test11 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        socket.close();
    }
}
