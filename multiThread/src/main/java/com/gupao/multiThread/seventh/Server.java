package com.gupao.multiThread.seventh;

import java.util.concurrent.BlockingQueue;

public class Server implements Runnable {

    private BlockingQueue<String> blockingQueue;

    public Server(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String request = blockingQueue.take();
                System.out.println("deal with request : " + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
