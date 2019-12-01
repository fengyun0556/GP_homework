package com.study.exercise.charper4_1.test7;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("start = "+System.currentTimeMillis());
        Socket socket = new Socket("localhost", 8000);
        System.out.println("end = "+System.currentTimeMillis());
    }
}
