package com.laboratory.trees;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insertNodeIterative(8);
        tree.insertNodeIterative(10);
        tree.insertNodeIterative(3);

        tree.insertNodeIterative(14);
        tree.insertNodeIterative(6);
        tree.insertNodeIterative(1);

        tree.insertNodeIterative(4);
        tree.insertNodeIterative(13);
        tree.insertNodeIterative(7);

        System.out.println("\nPre Order");
        tree.preOrder(tree.getRoot());

        System.out.println("\nIn Order:");
        tree.inOrder(tree.getRoot());

        System.out.println("\nPost Order:");
        tree.postOrder(tree.getRoot());

        System.out.println("\nBreadth First:");
        tree.breadthFirst();

        tree.insertNodeRecursive(2);
        System.out.println();
        tree.inOrder(tree.getRoot());

        System.out.println(tree.searchRecursive(3, tree.getRoot()));
        Node n = tree.searchRecursive(3, tree.getRoot());
        System.out.println("Parent: " + tree.getParentOf(n, tree.getRoot()).getValue());
    }
}
