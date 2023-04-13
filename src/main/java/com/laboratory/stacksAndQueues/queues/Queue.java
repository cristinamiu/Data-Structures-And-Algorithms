package com.laboratory.stacksAndQueues.queues;

public class Queue {
    private class Node {
        int value;
        Node next;

        public Node() {}
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public Queue() {
        this.head = new Node();
        this.tail = new Node();
        this.length = -1;
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        length++;

        if (length == 0) {
            head.next = newNode;
            tail.next = newNode;
            return;
        }

        tail.next.next = newNode;
        tail.next = newNode;
    }

    public int dequeue() {
        if (length < 0) {
            System.out.println("Nothing to dequeue.");
            return -1;
        }

        int valueToDequeue = head.next.value;

        head.next = head.next.next;

        length--;

        return valueToDequeue;
    }

    public void print() {
        if (length < 0) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = head.next;

        System.out.println("\n" + "Queue is:");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
