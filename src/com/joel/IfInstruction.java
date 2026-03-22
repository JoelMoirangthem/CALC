package com.joel;

import java.util.List;

public class IfInstruction implements Instruction {
    private Expression condition;
    private List<Instruction> body;
    public IfInstruction(Expression condition, List<Instruction> body){
        this.condition = condition;
        this.body = body;
    }
    @Override
    public void execute(Environment env){
        Object result = condition.evaluate(env);
        if(!(result instanceof Boolean)){
            throw new RuntimeException("condition must be boolean");
        }
        if((Boolean)result){
            for(Instruction instr : body){
                instr.execute(env);
            }
        }
    }

}
