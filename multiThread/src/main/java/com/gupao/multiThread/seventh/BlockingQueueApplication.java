package com.gupao.multiThread.seventh;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueApplication {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        Client client = new Client(blockingQueue);
        Server server = new Server(blockingQueue);

        new Thread(client).start();
        new Thread(server).start();
    }

}
