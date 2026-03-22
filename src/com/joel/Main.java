package com.joel;

public class Main {
    public static void main(String[] args) {
        Environment env = new Environment();

        Instruction assign = new AssignInstruction("x", new NumberNode(10));
        Instruction print = new PrintInstruction(new VariableNode("x"));

        assign.execute(env);
        print.execute(env);
    }
}
