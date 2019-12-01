package com.study.exercise.charper4_1.test3;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        String strA = "服务端你好A\n";
        String strB = "服务端你好B\n";
        String strC = "服务端你好C\n";
        int allStrByteLength = (strA + strB + strC).getBytes().length;
        objectOutputStream.writeInt(allStrByteLength);
        objectOutputStream.flush();
        objectOutputStream.write(strA.getBytes());
        objectOutputStream.write(strB.getBytes());
        objectOutputStream.write(strC.getBytes());
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        int byteLength = objectInputStream.readInt();
        byte[] byteArray = new byte[byteLength];
        objectInputStream.readFully(byteArray);
        String newString = new String(byteArray);
        System.out.println(newString);

        strA = "服务端你好D\n";
        strB = "服务端你好E\n";
        strC = "服务端你好F\n";

        allStrByteLength = (strA + strB + strC).getBytes().length;
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

        objectOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
