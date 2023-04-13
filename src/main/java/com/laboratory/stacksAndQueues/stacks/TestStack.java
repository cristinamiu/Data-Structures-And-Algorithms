package com.laboratory.stacksAndQueues.stacks;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.print();

        System.out.println("Pop: " + stack.pop().val);

        stack.print();

        stack.push(65);
        stack.print();

        System.out.println("Top: " + stack.top().val);
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.push(99);
        stack.push(89);
        stack.print();
    }
}
