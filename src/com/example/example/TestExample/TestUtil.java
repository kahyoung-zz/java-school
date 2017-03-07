package com.example.example.TestExample;

/**
 * This is the main class that we'll use to create Tests for
 */
class TestUtil {
    Double sum(Number a, Number b) {
        if (a == null || b == null) {
            return null;
        }

        return a.doubleValue() + b.doubleValue();
    }

    Double multiply(Number a, Number b) {
        if (a == null || b == null) {
            return null;
        }

        return a.doubleValue() * b.doubleValue();
    }
}
