package com.joel.runtime;
import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Object> variables;
    public Environment() {
        this.variables = new HashMap<>();
    }

    // store and update variables
    public void set(String name,Object value){
        variables.put(name,value);
    }
    // retrieve variable value
    public Object get(String name){
        if (!variables.containsKey(name)){
            throw new RuntimeException("Variable '" + name + "' is not defined.");
        }
        return variables.get(name);
    }

}
