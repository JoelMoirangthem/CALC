package com.parser;
import java.util.List;
import com.lexer.*;
import com.parser.nodes.*;
import com.instructions.*;
import java.util.ArrayList;
public class Parser {
    private final List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
    
    // first we have to parse the tokens and create an abstract syntax tree
    public List<Instruction> parse(){
        List<Instruction> intructions = new ArrayList<>();
        while(!match(TokenType.EOF)){
            if(match(TokenType.NEWLINE)) continue;
            intructions.add(parseInstruction());
        }
        return intructions;
    }

    // parse the instruction
    private Instruction parseInstruction(){
        if(check(TokenType.IDENTIFIER)&& checkNext(TokenType.ASSIGN)){
            return parseAssign();
        }
        if(match(TokenType.PRINT)){
            return parsePrint();
        }
        if(match(TokenType.IF)){
            return parseIf();
        }
        if(match(TokenType.LOOP)){
            return parseLoop();
        }
        throw error("Invalid instruction");

    }

    // parse the assignment instruction
    private Instruction parseAssign(){
        // first we have to consume the variable name and then we have to consume the := token
        // eg x := 5
        // we have to consume x and then we have to consume := and then we have to parse the expression 5
        String name = consume(TokenType.IDENTIFIER,"Expected variable name").getValue();
        consume(TokenType.ASSIGN,"Expected :=");
        Expression value = parseExpression();
        return new AssignInstruction(name,value);
    }
    private Instruction parsePrint(){
        // first we have to consume the >> token and then we have to parse the expression
        // eg >> x + 5
        // we have to consume >> and then we have to parse the expression x + 5
        Expression value = parseExpression();
        return new PrintInstruction(value);
    }
    // parse the if instruction
    // eg ? x > 5 =>
    // we have to consume ? and then we have to parse the condition x > 5
    private Instruction parseIf(){
        Expression condition = parseExpression();
        consume(TokenType.ARROW,"Expected =>");
        List<Instruction> body = new ArrayList<>();
        while(!check(TokenType.EOF) && !check(TokenType.NEWLINE)){
            body.add(parseInstruction());
        }
        return new IfInstruction(condition,body);
    } 
    private Instruction parseLoop(){
        Expression countExpression = parseExpression();
        consume(TokenType.ARROW,"Expected =>");
        List<Instruction> body = new ArrayList<>();
        while(!check(TokenType.EOF) && !check(TokenType.NEWLINE)){
            body.add(parseInstruction());
        }
        return new RepeatInstruction(countExpression,body);
    }
    // parse the expression
    // eg x + 5
    // we have to parse the left ,then operator and then the right
    private Expression parseExpression(){
        Expression left = parseTerm();
        while(match(TokenType.PLUS,TokenType.MINUS)){
            String operator = previous().getValue();
            Expression right = parseTerm();
            left = new BinaryOpNode(left,operator,right);
        }
        return left;
    }
    // parse the term
    // eg x * 5 
    // we have to parse the left ,then operator and then the right
    private Expression parseTerm(){
        Expression left = parsePrimary();
        while(match(TokenType.MUL,TokenType.DIV,TokenType.MOD)){
            String operator = previous().getValue();
            Expression right = parsePrimary();
            left = new BinaryOpNode(left,operator,right);
        }
        return left;

    }
    // parse the primary
    // eg x or 5
    // we have to check if it is a number or a variable
    private Expression parsePrimary(){
        if(match(TokenType.NUMBER)){
            return new NumberNode(Double.parseDouble(previous().getValue()));
        }
        if(match(TokenType.STRING)){
            return new StringNode(previous().getValue());  
        }
        if(match(TokenType.IDENTIFIER)){
            return new VariableNode(previous().getValue());
        }
        throw error("Expected expression");
    }
    // helper methods
    private boolean match(TokenType type){
        // check current token is of the given type or not
        if(check(type)){
            pos++;
            return true;
        }
        return false;
    }
    
    private boolean match(TokenType... types){
        for(TokenType type : types){
            if(check(type)){
                pos++;
                return true;
            }
        }
        return false;
    }
    // check the current token is of the given type or not
    private boolean check(TokenType type){
        if(pos >= tokens.size()) return false;
        return tokens.get(pos).getType() == type;
    }
    // check the next token is of the given type or not
    // eg x := 5
    // if the x is current token then := is next token
    
    private boolean checkNext(TokenType type){
        if(pos + 1 >= tokens.size()) return false;
        return tokens.get(pos + 1).getType() == type;
    }
    // consume the current token if it is of the given type or throw an error
    private Token consume(TokenType type,String message){
        if(check(type)) return tokens.get(pos++);
        throw error(message);
    }
    
    
    // previous token
    private Token previous(){
        return tokens.get(pos - 1);
    }
    // runtime error
    private RuntimeException error(String message){
        return new RuntimeException("Parser error at token " + previous() + ": " + message);
    }
}   
