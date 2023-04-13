package com.laboratory.linkedList.doubly;

import com.laboratory.linkedList.LinkedList;
import com.laboratory.linkedList.Node;

public class DoublyLinkedList implements LinkedList {
    private Node head;

    public DoublyLinkedList(int[] arr) {
        for (int item : arr) append(item);
    }
    @Override
    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.setNext(this.head);
        this.head.getNext().setPrev(newNode);
        head = newNode;
    }

    @Override
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        newNode.setPrev(current);
    }

    @Override
    public void insertBefore(int value, int before) {
        Node current = this.head;
        Node newNode = new Node(value);

        while(current.getNext() != null) {
            if (current.getValue() == before)
                break;
            current = current.getNext();
        }

        if (current.getPrev() == null){
            prepend(value);
            return;
        }

        newNode.setNext(current);
        newNode.setPrev(current.getPrev());
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
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
        newNode.setPrev(current);
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
    }

    @Override
    public void deleteHead() {
        this.head = this.head.getNext();
        this.head.setPrev(null);
    }

    @Override
    public void delete(int value) {
        Node current = this.head;
        boolean found = false;

        while (current.getNext() != null) {
            if (current.getValue() == value) {
                found = true;
                break;
            }
            current = current.getNext();
        }

        if (found) {
            if (current.getPrev() == null)
                deleteHead();
            else if (current.getNext() == null) {
                current.getPrev().setNext(null);
                current.setPrev(null);
            } else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                current.setPrev(null);
                current.setNext(null);
            }
        }
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
