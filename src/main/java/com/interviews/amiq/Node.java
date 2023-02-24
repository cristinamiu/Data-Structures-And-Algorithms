package com.lab.practice.interviews.amiq;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private Node parent;
    private List<Node> children;

    public Node(String value) {
        this.value = value;
        this.parent = null;
        this.children = null;
    }

    public void addChild(String value) {
        if (this.children == null)
            this.children = new ArrayList<>();

        Node child = new Node(value);
        child.setParent(this);

        this.children.add(child);
    }

    public static void printTree(Node current) {
        System.out.print(current.getValue());
        System.out.print(" ");

        if (current.getChildren() != null) {
            for (Node child : current.getChildren()) {
                printTree(child);
            }
        }
    }

    public static void printSubtypes(List<Node> nodeList, String value) {
        Node found = null;
        for(Node node : nodeList) {
            if (found != null)
                break;
            found = node.findNode(value);
        }

        if (found == null) {
            System.out.println("No " + value + " declarations");
        } else {
            found.printSubtypes(value);
        }

    }

    public void printSubtypes(String value) {
        Node found = findNode(this, value);

        if (found == null) {
            System.out.println("No " + value + " declarations");
            return;
        }

        printSubtypes(found);

        System.out.println("");
    }
    public void printSubtypes(Node current) {
        int count = 0;
        System.out.print(current.getValue());

        if (current.getChildren() == null)
            return;

        System.out.print(":{");
            for (Node child : current.getChildren()) {
                printSubtypes(child);
                if (current.getChildren().size() > 1 && count < current.getChildren().size()-1){
                    count++;
                    System.out.print(",");
                }

            }

            System.out.print("}");

    }

    public static void printSupertypes(List<Node> nodeList, String value) {
        Node found = null;
        for(Node node : nodeList) {
            if (found != null)
                break;
            found = node.findNode(value);
        }

        if (found == null) {
            System.out.println("No " + value + " declarations");
        } else {
            found.printSupertypes(value);
        }

    }

    public void printSupertypes(String value) {
        Node found = findNode(this, value);

        if (found == null) {
            System.out.println("No " + value + " declarations");
            return;
        }

        printSupertypes(found);

        System.out.println("");
    }

    public void printSupertypes(Node node) {
        System.out.print(node.getValue());

        if (node.getParent() == null)
            return;

        System.out.print(":{");
        printSupertypes(node.parent);
        System.out.print("}");
    }

    public Node findNode(String value) {
        return findNode(this, value);
    }

    public static boolean containsNode(Node node, String value) {
        return findNode(node, value) != null;
    }
    public static Node findNode(Node node, String value) {
        Node found = null;

        if (node.getValue().equals(value))
            return node;

        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                if (found == null)
                    found = findNode(child, value);
            }
        }

        return found;
    }

    // GETTERS AND SETTERS

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
