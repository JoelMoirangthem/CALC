package com.joel.ast;
import com.joel.runtime.Environment;
public interface Expression {
    Object evaluate(Environment env);
}
