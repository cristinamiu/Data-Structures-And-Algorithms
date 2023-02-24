package com.lab.practice.interviews.amiq;

import java.util.List;

public class InputFormat {
    private int declarationNumber;
    private int commandNumber;
    private List<String> declarations;
    private List<String> commands;

    public InputFormat() {
    }

    public int getDeclarationNumber() {
        return declarationNumber;
    }

    public void setDeclarationNumber(String declarationNumber) {
        this.declarationNumber = Integer.parseInt(declarationNumber);
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(String commandNumber) {
        this.commandNumber = Integer.parseInt(commandNumber);
    }

    public List<String> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<String> declarations) {
        int from = 1;
        int to = declarationNumber + 1;
        this.declarations = declarations.subList(from, to);
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        int from = declarationNumber + 1;
        int to = declarationNumber + commandNumber + 1;
        this.commands = commands.subList(from, to);
    }
}
