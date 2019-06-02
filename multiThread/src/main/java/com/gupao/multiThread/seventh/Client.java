package com.gupao.multiThread.seventh;

import java.util.concurrent.BlockingQueue;

public class Client implements Runnable {

    private BlockingQueue blockingQueue;

    public Client(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                blockingQueue.put("请求" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
