package com.study.exercise.charper4_1.test3;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        int byteLength = objectInputStream.readInt();
        byte[] byteArray = new byte[byteLength];
        objectInputStream.readFully(byteArray);
        String newString = new String(byteArray);
        System.out.println(newString);
        OutputStream outputStream = socket.getOutputStream();
        String strA = "客户端你好A\n";
        String strB = "客户端你好B\n";
        String strC = "客户端你好C\n";
        int allStrByteLength = (strA + strB + strC).getBytes().length;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeInt(allStrByteLength);
        objectOutputStream.flush();
        objectOutputStream.write(strA.getBytes());
        objectOutputStream.write(strB.getBytes());
        objectOutputStream.write(strC.getBytes());
        objectOutputStream.flush();

        byteLength = objectInputStream.readInt();
        byteArray = new byte[byteLength];
        objectInputStream.readFully(byteArray);
        newString = new String(byteArray);
        System.out.println(newString);

        strA = "客户端你好D\n";
        strB = "客户端你好E\n";
        strC = "客户端你好F\n";

        allStrByteLength = (strA + strB + strC).getBytes().length;
        objectOutputStream.writeInt(allStrByteLength);
        objectOutputStream.flush();
        objectOutputStream.write(strA.getBytes());
        objectOutputStream.write(strB.getBytes());
        objectOutputStream.write(strC.getBytes());
        objectOutputStream.flush();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
