package com.example.example.EnumExample;

/**
 * This example demonstrates how far you could take an enum
 *
 * For example, enums can be extended to minify the amount of switch/case statements through an application
 * by handling abstract methods within each type
 *
 */
public class EnumExample {
    public static void main(String[] args) {
        ContactMethod.PHONE.initiate("kahyoung");
        ContactMethod.EMAIL.initiate("nahold");
    }


}
