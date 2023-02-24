package com.interviews.amiq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessInput {

    public static InputFormat processInput(String input) {
        InputFormat inputFormat = new InputFormat();

        String[] rows = input.split("\n");

        inputFormat.setDeclarationNumber(rows[0].split(" ")[0]);
        inputFormat.setCommandNumber(rows[0].split(" ")[1]);

        inputFormat.setDeclarations(Arrays.asList(rows));
        inputFormat.setCommands(Arrays.asList(rows));

        return inputFormat;
    }

    public static List<Node> constructTreeList(InputFormat inputFormat) {
        List<Node> nodeList = new ArrayList<>();

        for (String declaration : inputFormat.getDeclarations()) {
            processDeclaration(nodeList, declaration);
        }

        return nodeList;
    }

    public static void processCommands(InputFormat inputFormat, List<Node> nodeList) {
        List<String> commands = inputFormat.getCommands();

        for (String command : commands) {
            String cmd = command.split(" ")[0];
            String cls =  command.split(" ")[1];

            switch (cmd) {
                case "supertypes":
                    Node.printSupertypes(nodeList, cls);
                    break;
                case "subtypes":
                    Node.printSubtypes(nodeList, cls);
                    break;
                default:
                    break;
            }
        }
    }

    private static void processDeclaration(List<Node> nodeList, String declaration) {
        String[] split = declaration.split(" ");
        String className = split[1];
        String parentName = split.length == 4 ? split[3] : "";

        for (Node node : nodeList) {
            if (Node.containsNode(node, className))
                return;
        }

        Node newNode = new Node(className);

        if (parentName.isEmpty()) {
            nodeList.add(newNode);
        } else {
            setInheritance(nodeList, split, newNode, null);
        }
    }

    private static void setInheritance(List<Node> nodeList, String[] split, Node newNode, Node found) {
        for (Node node : nodeList) {
            if (found != null)
                break;
            found = node.findNode(split[3]);
        }

        if (found != null) {
            found.addChild(split[1]);
            newNode.setParent(found);
        }
    }
}
