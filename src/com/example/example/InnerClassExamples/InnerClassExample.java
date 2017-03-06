package com.example.example.InnerClassExamples;

/**
 * This example aims to demonstrate the importance of deciding whether an inner class should be static, or not
 *
 * Here are the most important aspects to be aware of:
 * - Non static Inner Classes have full access to its enclosing class - this can have a high cost as every inner class
 * has a reference to another bean - it also REQUIRES the enclosing class to always be around
 * - Has a hard time being read by reflection
 *
 * - Static Inner Classes are  the opposite - They don't have a reference, and they don't REQUIRE that reference -
 * in fact a static inner class can stay alive much longer than its enclosing class. Also, this type of class is a lot
 * easier to move to its own class if it outgrows its enclosure
 *
 */
public class InnerClassExample {

    public static void main(String[] args) {
        BasicClass basicClass = new BasicClass();
        BasicInterface basicClassInterface = basicClass.create();
        System.out.println(basicClassInterface.parse("I'm kind of happy... "));

        StaticClass staticClass = new StaticClass();
        BasicInterface staticClassInterface = staticClass.create();
        System.out.println(staticClassInterface.parse("I'm so happy! "));
    }
}
