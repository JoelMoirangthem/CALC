package com.instructions;
import com.parser.nodes.Expression;
import com.runtime.Environment;
import java.util.List;
public class RepeatInstruction implements Instruction {
    private final Expression countExpression;
    private final List<Instruction> body;
    public RepeatInstruction(Expression countExpression,List<Instruction> body){
        this.countExpression = countExpression;
        this.body = body;
    }
    // execute the instruction by evaluating the count expression and executing the body of the repeat statement the number of times specified by the count expression
    // eg repeat 5 times print "Hello" will evaluate 5 and execute the body
    public void execute(Environment env){
        Object val = countExpression.evaluate(env);
        // check if the result of the count expression is a number, if not throw an exception
        if(!(val instanceof Number)){
            throw new RuntimeException("Count expression must be a number");
        }
        // convert the result to an integer and execute the body that many times
        int count = ((Number) val).intValue();
        for(int i = 0; i < count; i++){
            for(Instruction instruction : body){
                instruction.execute(env);
            }
        }

    }
}
