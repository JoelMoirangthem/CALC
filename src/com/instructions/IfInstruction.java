package com.instructions;
import com.parser.nodes.Expression;
import com.runtime.Environment;
import java.util.List;
public class IfInstruction implements Instruction{
    private final Expression condition;
    private final List<Instruction> body;
    public IfInstruction(Expression condition,List<Instruction> body){
        this.condition = condition;
        this.body = body;
    }
    // execute the instruction by evaluating the condition
    // if the condition is true, execute the body of the if statement
    // eg if x > 5 then print x will evaluate x > 5 and if it is true, it will execute the body of the if statement which is print x
    @Override
    public void execute(Environment env){
        Object result = condition.evaluate(env);
        // check if the result of the condition is a boolean, if not throw an exception
        if(!(result instanceof Boolean)){
            throw new RuntimeException("Condition must be a boolean");
        }
        // if the result of the condition is true, execute the body of the if statement
        if((Boolean) result){
            for(Instruction instruction : body){
                instruction.execute(env);
            }
        }
    }
}