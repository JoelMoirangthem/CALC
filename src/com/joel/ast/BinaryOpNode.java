package com.joel.ast;

import com.joel.runtime.Environment;

public class BinaryOpNode implements Expression {

    private Expression left;
    private Expression right;
    private Operator operator; 
    public BinaryOpNode(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = Operator.fromString(operator); 
        this.right = right;
    }

    @Override
    public Object evaluate(Environment env) {

        Object leftVal = left.evaluate(env);
        Object rightVal = right.evaluate(env);

        
        if (leftVal == null || rightVal == null) {
            throw new RuntimeException("Null value in binary operation is not valid");
        }

        switch (operator) {

            case PLUS:
                if (leftVal instanceof String || rightVal instanceof String) {
                    return String.valueOf(leftVal) + String.valueOf(rightVal);
                }
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() +
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for +");

            case MINUS:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() -
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for -");

            case MUL:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() *
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for *");

            case DIV:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    double r = ((Number) rightVal).doubleValue();
                    if (r == 0) {
                        throw new RuntimeException("Division by zero");
                    }
                    return ((Number) leftVal).doubleValue() / r;
                }
                throw new RuntimeException("Invalid operands for /");

            case MOD:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    double r = ((Number) rightVal).doubleValue();
                    if (r == 0) {
                        throw new RuntimeException("Division by zero");
                    }
                    return ((Number) leftVal).doubleValue() % r;
                }
                throw new RuntimeException("Invalid operands for %");

            case EQ:
                return leftVal.equals(rightVal);

            case NEQ:
                return !leftVal.equals(rightVal);

            case LT:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() <
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for <");

            case GT:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() >
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for >");

            case LTE:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() <=
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for <=");

            case GTE:
                if (leftVal instanceof Number && rightVal instanceof Number) {
                    return ((Number) leftVal).doubleValue() >=
                           ((Number) rightVal).doubleValue();
                }
                throw new RuntimeException("Invalid operands for >=");

            default:
                throw new RuntimeException("Unhandled operator: " + operator);
        }
    }
}