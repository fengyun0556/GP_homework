package com.study.exercise.charper3_1;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Test1 {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println(eachNetworkInterface.getName());
            System.out.println(eachNetworkInterface.getDisplayName());
            System.out.println(eachNetworkInterface.getIndex());
            System.out.println(eachNetworkInterface.isUp());
            System.out.println(eachNetworkInterface.isLoopback());
            System.out.println(eachNetworkInterface.getMTU());
            byte[] bytes = eachNetworkInterface.getHardwareAddress();
            if (bytes != null){
                for (int i = 0; i < bytes.length; i++) {
                    System.out.print(bytes[i]+" ");
                }
            }
            System.out.println();
            Enumeration<InetAddress> enumerationInetAddress = eachNetworkInterface.getInetAddresses();
            while (enumerationInetAddress.hasMoreElements()){
                InetAddress inetAddress = enumerationInetAddress.nextElement();
                System.out.println("getCanonicalHostName="+inetAddress.getCanonicalHostName());
                System.out.println("getHostName="+inetAddress.getHostName());
                System.out.println("getHostAddress="+inetAddress.getHostAddress());
                System.out.print("IP address=");
                byte[] addressByte = inetAddress.getAddress();
                for (int i = 0; i < addressByte.length; i++) {
                    System.out.print(addressByte[i]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}
