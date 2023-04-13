package com.laboratory.stacksAndQueues.heap;

public class Test {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);

        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(10);

        heap.print();

        heap.deleteMin();

        heap.print();
    }
}
