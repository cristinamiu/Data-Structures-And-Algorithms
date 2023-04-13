package com.laboratory.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;

    private int nodes;

    public Node getRoot() {
        return root;
    }

    public Tree() {
        this.root = null;
        this.nodes = 0;
    }

    public void insertNodeIterative(int value) {
        if (nodes == 0)
            root = new Node(value);
        else
            insertIterative(value, root);
        nodes++;
    }

    private static void insertIterative(int value, Node current) {
        Node parent = null;

        while (current != null) {
            parent = current;
            if (value <= current.getValue())
                current = current.getLeft();
            else
                current = current.getRight();
        }

        Node newNode = new Node(value);

        assert parent != null;
        if (value <= parent.getValue())
            parent.setLeft(newNode);
        else
            parent.setRight(newNode);
    }

    public void insertNodeRecursive(int value) {
        if (nodes == 0)
            root = new Node(value);
        else
            insertRecursive(value, root, null);

        nodes++;
    }

    private void insertRecursive(int value, Node node, Node parent) {
        if (node == null) {
            if (value <= parent.getValue())
                parent.setLeft(new Node(value));
            else
                parent.setRight(new Node(value));
            return;
        }

        if (value <= node.getValue()) {
            insertRecursive(value, node.getLeft(), node);
        } else
            insertRecursive(value, node.getRight(), node);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());


    }

    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void breadthFirst() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.getValue() + " ");

            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
    }

    public Node searchRecursive(int value, Node current) {
        if (current == null) {
            System.out.println("Not found.");
            return null;
        }

        if (value == current.getValue())
            return current;

        if (value <= current.getValue())
            return searchRecursive(value, current.getLeft());
        else
            return searchRecursive(value, current.getRight());
    }

    public Node getParentOf(Node node, Node current) {
        if (current == null)
            return null;

        if (current.getLeft().getValue() == node.getValue() ||
            current.getRight().getValue() == node.getValue())
            return current;

        if (node.getValue() <= node.getValue())
            return getParentOf(node, current.getLeft());
        else
            return getParentOf(node, current.getRight());
    }

    public boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public boolean hasTwoSuccessors(Node node) {
        return node.getLeft() != null && node.getRight() != null;
    }

    public void remove(int value) {
        Node nodeToRemove = searchRecursive(value, root);

        if (nodeToRemove == null) {
            System.out.println("Value " + value + " does not exist in tree.");
            return;
        }

        if (isLeaf(nodeToRemove)) {
            Node parent = getParentOf(nodeToRemove, root);

            if (parent.getLeft().getValue() == nodeToRemove.getValue())
                parent.setLeft(null);
            if (parent.getRight().getValue() == nodeToRemove.getValue())
                parent.setRight(null);
            return;
        }

        if (!hasTwoSuccessors(nodeToRemove)) {
            Node parent = getParentOf(nodeToRemove, root);
        }
    }
}
