package com.study.exercise.charper1_3;

import java.nio.ByteBuffer;

public class Test13_1 {
    public static void main(String[] args) {
        byte[] byteArray = {1,2,3,4,5,6,7,8,9};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        int remaining = byteBuffer.remaining();
        for (int i = 0; i < remaining; i++) {
            System.out.print(byteBuffer.get()+" ");
        }
        System.out.println();
        byteBuffer.clear();
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get()+" ");
        }
        System.out.println();
        byteBuffer.clear();
        for(;byteBuffer.hasRemaining();){
            System.out.print(byteBuffer.get()+" ");
        }
    }
}
