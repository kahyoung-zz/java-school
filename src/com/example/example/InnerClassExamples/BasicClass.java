package com.example.example.InnerClassExamples;

/**
 * This is a basic class which has an inner bean (non-static nested bean)
 */
class BasicClass {
    BasicInterface create() {
        return new BasicInterfaceImpl();
    }

    /**
     * Inner class
     */
    private class BasicInterfaceImpl implements BasicInterface {
        @Override
        public String parse(String str) {
            return str.concat("Yay!");
        }
    }
}
