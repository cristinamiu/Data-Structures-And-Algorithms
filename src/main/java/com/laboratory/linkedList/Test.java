package com.laboratory.linkedList;

import com.laboratory.linkedList.doubly.DoublyLinkedList;
import com.laboratory.linkedList.simply.SimplyLinkedList;

public class Test {
    public static void main(String[] args) {
        System.out.println("[*] Simply Linked List:");
        testSimplyLinkedList();
        System.out.println("[*] Doubly Linked List:");
        testDoublyLinkedList();
    }

    private static void testSimplyLinkedList() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        SimplyLinkedList linkedList = new SimplyLinkedList(arr);
        executeOperations(linkedList);
    }

    private static void testDoublyLinkedList() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        DoublyLinkedList linkedList = new DoublyLinkedList(arr);
        executeOperations(linkedList);
    }

    private static void executeOperations(LinkedList linkedList) {
        linkedList.show();
        linkedList.append(6);
        linkedList.insertBefore(7,6);
        linkedList.insertBefore(8,1);
        linkedList.insertAfter(9,6);
        linkedList.show();
        linkedList.deleteHead();
        linkedList.show();
        linkedList.delete(8);
        linkedList.delete(4);
        linkedList.show();
    }
}
