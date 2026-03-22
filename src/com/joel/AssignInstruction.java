package com.joel;

public class AssignInstruction implements Instruction{
    private String varName;
    private Expression exp;
    public AssignInstruction(String varName,Expression exp){
        this.varName = varName;
        this.exp = exp;
    }
    @Override
    public void execute(Environment env){
        Object value = exp.evaluate(env);
        env.set(varName,value);
    }

}
