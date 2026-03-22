package com.joel;

public class PrintInstruction implements Instruction {
    private Expression exp;
    public PrintInstruction(Expression exp){
        this.exp = exp;
    }
    @Override
    public void execute(Environment env){
        System.out.println(exp.evaluate(env));
    }
}
