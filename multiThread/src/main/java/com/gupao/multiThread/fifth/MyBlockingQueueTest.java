package com.gupao.multiThread.fifth;

public class MyBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue blockingQueue = new MyBlockingQueue(5);

        Runnable r1 = new PutThread(blockingQueue);
        Runnable r2 = new TakeThread(blockingQueue);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    static class PutThread implements Runnable {

        private final MyBlockingQueue blockingQueue;

        public PutThread(MyBlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    blockingQueue.put(String.valueOf(i));
                    if (i % 5 == 0){
                        Thread.sleep(2000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TakeThread implements Runnable {

        private final MyBlockingQueue blockingQueue;

        public TakeThread(MyBlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
