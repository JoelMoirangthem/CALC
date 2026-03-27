package com.joel.instruction;
import com.joel.runtime.Environment;
import com.joel.ast.Expression;
public class AssignInstruction implements Instruction {
    private String name;
    private Expression expression;
    public AssignInstruction(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }
    @Override
    public void execute(Environment env) {
        Object value = expression.evaluate(env);
        env.set(name, value);
    }
}
