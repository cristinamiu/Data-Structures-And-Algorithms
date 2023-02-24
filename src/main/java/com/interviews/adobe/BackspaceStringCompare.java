package com.interviews.adobe;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }

    private static Stack<Character> process(String str) {
        Stack<Character> stack = new Stack<>();

        for (Character c : str.toCharArray()) {
            if (!c.equals('#'))
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }

        return stack;
    }
}
