package com.example.example.InnerClassExamples;

/**
 * Generic class which contains a static nested class
 */
class StaticClass {
    BasicInterface create() {
        return new BasicInterfaceImpl();
    }

    /**
     * Inner class
     */
    private static class BasicInterfaceImpl implements BasicInterface {
        @Override
        public String parse(String str) {
            return str.concat("WooHoo!");
        }
    }
}
