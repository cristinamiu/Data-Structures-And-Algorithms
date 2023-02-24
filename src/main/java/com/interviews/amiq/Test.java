package com.lab.practice.interviews.amiq;

public class Test {
    public static void main(String[] args) {
        String input = getInput();

        System.out.println(input);

        InputFormat inputFormat = ProcessInput.processInput(input);

        ProcessInput.processCommands(inputFormat, ProcessInput.constructTreeList(inputFormat));
    }

    private static String getInput() {
        return """
                10 6
                class a
                class b extends a
                class c extends a
                class d extends b
                class e extends d
                class a
                class g extends f
                class i extends g
                class j extends g
                class k extends f
                subtypes a
                supertypes b
                subtypes c
                supertypes e
                supertypes h
                subtypes d""";
    }
}
