package com.joel;

public class BinaryOpNode implements Expression{
    private Expression left;
    private Expression right;
    private String op;
    public BinaryOpNode(Expression left,String op,Expression right){
        this.left = left;
        this.op = op;
        this.right = right;
    }
    @Override
    public Object evaluate(Environment env){
        Object leftVal = left.evaluate(env);
        Object rightVal = right.evaluate(env);
        if(op.equals('+')){
            return (Double) leftVal + (Double) rightVal;
        }else if(op.equals('-')){
            return (Double) leftVal - (Double) rightVal;
        }else if(op.equals('*')){
            return (Double) leftVal * (Double) rightVal;
        }
        else if(op.equals('/')){
            return (Double) leftVal / (Double) rightVal;
        }else if(op.equals('%')){
            return (Double) leftVal % (Double) rightVal;
        }else if(op.equals("==")){
            return leftVal.equals(rightVal);
        }else if(op.equals("!=")){
            return !leftVal.equals(rightVal);
        }else if(op.equals("<")){
            return (Double) leftVal < (Double) rightVal;
        }
        else if(op.equals(">")){
            return (Double) leftVal > (Double) rightVal;
        }else if(op.equals("<=")){
            return (Double) leftVal <= (Double) rightVal;
        }else if(op.equals(">=")){
            return (Double) leftVal >= (Double) rightVal;
        }else if(op.equals("&&")){
            return (Boolean) leftVal && (Boolean) rightVal;
        }else if(op.equals("||")){
            return (Boolean) leftVal || (Boolean) rightVal;
        }else{
            throw new RuntimeException("Unknown operator: " + op);
        }

    }
}
