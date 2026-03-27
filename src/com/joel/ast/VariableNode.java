package com.joel.ast;
import com.joel.runtime.Environment;
public class VariableNode implements Expression {
    private String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public Object evaluate(Environment env) {
        return env.get(name);
    }
}
