package com.joel.ast;

import com.joel.runtime.RunTimeException;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    EQ("=="),
    NEQ("!="),
    LT("<"),
    GT(">"),
    LTE("<="),
    GTE(">=");
    
    private final String symbol;
    Operator(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
    public static Operator fromString(String op){
        for(Operator operator : Operator.values()){
            if(operator.getSymbol().equals(op)){
                return operator;
            }
        }
        throw new RunTimeException("Unknown operator: " + op);
    }
}
