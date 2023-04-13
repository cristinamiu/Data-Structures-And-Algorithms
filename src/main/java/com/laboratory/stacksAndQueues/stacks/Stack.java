package com.laboratory.stacksAndQueues.stacks;

public class Stack {
    public class Node {
        int val;
        Node next;
        public Node(){};
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node top;
    private int length;

    public Stack() {
        this.top = new Node();
        this.length = -1;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        length++;

        if (length == 0) {
            top.next = newNode;
            return;
        }

        newNode.next = top.next;
        top.next = newNode;
    }

    public Node pop() {
        Node popResult = top.next;

        top.next = top.next.next;
        length--;

        return popResult;
    }

    public Node top() {
        return top.next;
    }

    public void print() {
        Node current = top.next;
        System.out.println("\n" + "Stack is:");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
