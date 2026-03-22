package com.joel;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Object> varStore = new HashMap<>();

    public void set(String name, Object value) {
        varStore.put(name, value);
    }

    public Object get(String name) {
        if (!varStore.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " not found in environment");
        }
        return varStore.get(name);
    }
}