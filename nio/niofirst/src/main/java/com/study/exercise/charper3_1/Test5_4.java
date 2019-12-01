package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_4 {
    public static void main(String[] args) throws Exception {
        byte[] byteArray = new byte[]{-64, -88, 0, 102};
        InetAddress myAddress = InetAddress.getByAddress(byteArray);
        System.out.println(myAddress.getHostAddress());
        System.out.println(myAddress.getHostName());
        System.out.println(myAddress.getClass().getName());

    }
}
