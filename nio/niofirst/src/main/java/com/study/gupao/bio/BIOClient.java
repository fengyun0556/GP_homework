package com.study.gupao.bio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream os = socket.getOutputStream();
        String message = UUID.randomUUID().toString();
        os.write(message.getBytes());
        os.flush();
        os.close();
        socket.close();
    }
}
