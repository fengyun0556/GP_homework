package com.gupao.multiThread.fifth;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {

    private ReentrantLock lock = new ReentrantLock();

    private Condition putCondition = lock.newCondition();

    private Condition takeCondition = lock.newCondition();

    private Node head = new Node(null, null, null);

    private Node tail = new Node(null, null, null);

    private final int maxLength;

    private AtomicInteger currentLength = new AtomicInteger(0);

    public MyBlockingQueue(int maxLength) {
        this.maxLength = maxLength;
        head.next = tail;
        tail.prev = head;
    }

    public void put(Object o) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (currentLength.get() == maxLength) putCondition.await();

            Node newNode = new Node(head, head.next, o);
            head.next.prev = newNode;
            head.next = newNode;

            currentLength.incrementAndGet();
            takeCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public Object take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (currentLength.get() == 0) takeCondition.await();
            Object result = tail.prev.data;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;

            currentLength.decrementAndGet();
            putCondition.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    private class Node{
        private Node prev;
        private Node next;
        private Object data;

        private Node(Node prev, Node next, Object data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

}
