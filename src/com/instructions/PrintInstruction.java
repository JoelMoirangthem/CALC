package  com.instructions;
import com.parser.nodes.Expression;
import com.runtime.Environment;

public class PrintInstruction implements Instruction{
    private final Expression expression;
    public PrintInstruction(Expression expression){
        this.expression = expression;
    }
    // execute the instruction by evaluating the expression and printing the result to the console
    // eg print 5 + 3 will evaluate 5 + 3 and print the
    // result to the console
    @Override
    public void execute(Environment env){
        Object value = expression.evaluate(env);
        System.out.println(value);
    }
}