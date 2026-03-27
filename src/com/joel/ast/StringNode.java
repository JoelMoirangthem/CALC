package com.joel.ast;
import com.joel.runtime.Environment;

public class StringNode implements Expression {
    private String value;
    public StringNode(String value){
        this.value = value;
    }
    @Override
    public Object evaluate(Environment env){
        return value;
    }
}
