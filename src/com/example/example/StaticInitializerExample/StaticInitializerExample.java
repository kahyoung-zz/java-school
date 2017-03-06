package com.example.example.StaticInitializerExample;


/**
 * Static Initializers allow you to set up a class before any part of an application reads that class
 *
 * This allows for complex setups
 */
public class StaticInitializerExample {
    public static void main(String[] args) {
        System.out.println(StaticClass.CONSTANT_FLAGS);
    }
}
