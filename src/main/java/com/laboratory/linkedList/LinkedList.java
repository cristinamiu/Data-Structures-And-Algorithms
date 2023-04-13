package com.laboratory.linkedList;

public interface LinkedList {
    void prepend(int value);
    void append(int value);
    void insertBefore(int value, int before);
    void insertAfter(int value, int after);
    void deleteHead();
    void delete(int value);
    void show();
}
