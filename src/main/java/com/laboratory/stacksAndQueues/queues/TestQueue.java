package com.laboratory.stacksAndQueues.queues;

public class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.print();

        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);

        queue.print();

        queue.dequeue();
        queue.dequeue();

        queue.print();
    }
}
