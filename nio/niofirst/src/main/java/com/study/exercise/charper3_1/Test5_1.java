package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_1 {
    public static void main(String[] args) throws Exception {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.print("InetAddress.getLocalHost=");
        byte[] localIPAddress = localhost.getAddress();
        for (int i = 0; i < localIPAddress.length; i++) {
            System.out.print(" "+ localIPAddress[i] +" ");
        }
        System.out.println();
        System.out.println(localhost.getClass().getName());
        System.out.println();
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.print("InetAddress.getLoopbackAddress=");
        byte[] loopbackIPAddress = loopbackAddress.getAddress();
        for (int i = 0; i < loopbackIPAddress.length; i++) {
            System.out.print(" "+loopbackIPAddress[i]+" ");
        }
        System.out.println();
        System.out.println(localhost.getClass().getName());
    }
}
