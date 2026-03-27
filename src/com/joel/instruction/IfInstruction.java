package com.joel.instruction;
import com.joel.runtime.Environment;
import com.joel.ast.Expression;
import java.util.List;
public class IfInstruction implements Instruction {
    private Expression condition;
    private List<Instruction> body;
    public IfInstruction(Expression condition, List<Instruction> body) {
        this.condition = condition;
        this.body = body;
    }
    @Override
    public void execute(Environment env){
        Object condValue = condition.evaluate(env);
        if(!(condValue instanceof Boolean)){
            throw new RuntimeException("Condition in if statement must evaluate to a boolean");
        }
        if((Boolean) condValue){
            for(Instruction instr : body){
                instr.execute(env);
            }
        }
    }
}
