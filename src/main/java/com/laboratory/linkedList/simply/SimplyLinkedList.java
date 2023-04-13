package com.laboratory.linkedList.simply;

import com.laboratory.linkedList.LinkedList;
import com.laboratory.linkedList.Node;

public class SimplyLinkedList implements LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SimplyLinkedList(int[] arr) {
        for (int item : arr) this.append(item);
    }

    @Override
    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.setNext(this.head);
        this.head = newNode;
    }

    @Override
    public void append(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node current = this.head;
        Node newNode = new Node(value);

        while (current.getNext() != null) current = current.getNext();

        current.setNext(newNode);
    }

    public void makeCircular() {
        Node current = head;

        while (true) {
            if (current.getNext() == null) {
                current.setNext(head);
                break;
            }

            current = current.getNext();
        }
    }
    @Override
    public void insertBefore(int value, int before) {
        Node prev = null;
        Node current = this.head;

        Node newNode = new Node(value);

        while (current.getNext() != null){
            if (current.getValue() == before)
                break;
            prev = current;
            current = current.getNext();
        }

        if (prev == null) {
            prepend(value);
            return;
        }
        prev.setNext(newNode);
        newNode.setNext(current);
    }

    @Override
    public void insertAfter(int value, int after) {
        Node current = this.head;
        Node newNode = new Node(value);

        while(current.getNext() != null) {
            if (current.getValue() == after)
                break;
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    @Override
    public void deleteHead() {
        this.head = head.getNext();
    }

    @Override
    public void delete(int value) {
        boolean found = false;
        Node current = this.head;
        Node prev = null;

        while (current.getNext() != null) {
            if (current.getValue() == value) {
                found = true;
                break;
            }
            prev = current;
            current = current.getNext();
        }

        if (found) {
            if (prev == null)
                deleteHead();
            else
                prev.setNext(current.getNext());
        } else
            System.out.println("Item not found.");
    }

    @Override
    public void show() {
        Node current = this.head;
        System.out.println("Linked list is:");

        while (current.getNext() != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
