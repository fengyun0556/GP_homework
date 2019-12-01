package com.study.exercise.charper3_1;

import java.net.InetAddress;

public class Test5_5 {
    public static void main(String[] args) throws Exception {
        byte[] byteArray = new byte[]{-64, -88, 0, 102};
        InetAddress myAddress = InetAddress.getByAddress("zzzzzzz", byteArray);
        System.out.println("myAddress.getHostAddress="+myAddress.getHostAddress());
        System.out.println("myAddress.getHostName="+myAddress.getHostName());
        System.out.println("myAddress.getClass="+myAddress.getClass().getName());
    }
}
