package com.joel;

import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int current = 0;
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
    private Token currentToken(){
        return tokens.get(current);
    }
    private void advance(){
        current++;
    }
    private boolean match(TokenType type){
        if(currentToken().getType() == type){
            advance();
            return true;
        }
        return false;
    }
    private Instruction parseInstruction(){

        // Assignment → x := expr
        if(currentToken().getType() == TokenType.IDENTIFIER){
            String varName = currentToken().getValue();
            advance();
            if(match(TokenType.ASSIGN)){
                Expression exp = parseExpression();
                return new AssignInstruction(varName,exp);
            }
        }
        // Print → >> expr
        if(match(TokenType.PRINT)){
            Expression exp = parseExpression();
            return new PrintInstruction(exp);
        }
        // If -> ? condition =>
        
    }

}
