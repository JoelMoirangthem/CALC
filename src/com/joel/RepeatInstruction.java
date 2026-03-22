package com.joel;

import java.util.List;

public class RepeatInstruction implements Instruction  {
    private Expression count;
    private List<Instruction> body;
    public RepeatInstruction(Expression count, List<Instruction> body){
        this.count = count;
        this.body = body;
    }
    @Override
    public void execute(Environment env){
        Object result = count.evaluate(env);
        int times = ((Double) result).intValue();
        for(int i = 0; i < times; i++){
            for(Instruction instr : body){
                instr.execute(env);
            }
        }
    }

}
