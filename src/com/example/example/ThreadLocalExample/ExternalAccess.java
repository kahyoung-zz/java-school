package com.example.example.ThreadLocalExample;

/**
 * This class demonstrates how an external class can read the value stored in ThreadLocal
 */
class ExternalAccess {
    void printThreadId() {
        System.out.println("Called external class in thread: " + ThreadId.get());
    }
}
