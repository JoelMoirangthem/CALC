package com;
import com.interpreter.Interpreter;
public class Main {
    public static void main(String[] args) {
        String source = """
            x := 10
            y := 20
            z := x + y * 2
            >> z
            a := 1
            @ 5 => a := a * 2  % 5 >> a
        """;
        Interpreter interpreter = new Interpreter();
        interpreter.run(source);
    }
}
