package com.laboratory.stacksAndQueues.heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return 2 * index + 1;
    }

    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    public void insert(int value) {
        if (this.size == this.capacity) {
            System.out.println("Heap is full.");
            return;
        }

        int currentIndex = this.size;
        heap[currentIndex] = value;

        while (currentIndex != 0 && heap[currentIndex] < heap[getParent(currentIndex)]) {
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }

        this.size++;
    }

    public void deleteMin() {
        this.size--;
        heap[0] = heap[size];

        maintainMinHeap(0);

    }

    private void maintainMinHeap(int currentIndex) {
        if (size <= 1)
            return;

        int left = getLeftChild(currentIndex);
        int right = getRightChild(currentIndex);
        int smallestIndex = currentIndex;

        while (left < size && heap[left] < heap[smallestIndex])
            smallestIndex = left;

        while (right < size && heap[right] < heap[smallestIndex])
            smallestIndex = right;

        if (smallestIndex != currentIndex) {
            swap(smallestIndex, currentIndex);
            maintainMinHeap(currentIndex);
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void swap(int child, int parent) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }
}
