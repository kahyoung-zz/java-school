package com.example.example.StaticInitializerExample;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class is used to demonstrate how you could initialise a class before any other class accesses it
 *
 * In this case, we populate CONSTANT_FLAGS as a means of demonstrating this
 */
class StaticClass {
    static final Map<String, String> CONSTANT_FLAGS;

    // Run this before anyone else can access Static Class
    static {
        Map<String, String> flags = new HashMap<>();

        flags.put("first", "first");
        flags.put("second", "second");

        CONSTANT_FLAGS = flags;
    }
}
