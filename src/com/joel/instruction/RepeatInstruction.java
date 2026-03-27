package com.joel.instruction;
import java.util.List;
import com.joel.ast.Expression;
import com.joel.runtime.Environment;
public class RepeatInstruction implements Instruction{
    private Expression countExpr;
    private List<Instruction> body;
    public RepeatInstruction(Expression countExpr, List<Instruction> body){
        this.countExpr = countExpr;
        this.body = body;
    }
    @Override
    public void execute(Environment env){
        Object value  = countExpr.evaluate(env);
        if(! (value instanceof Integer)){
            throw new RuntimeException("Repeat count must evaluate to an integer");
        }
        int count = ((Number) value).intValue();
        for(int i = 0; i < count; i++){
            for(Instruction instr : body){
                instr.execute(env);
            }
        }

    }
}
