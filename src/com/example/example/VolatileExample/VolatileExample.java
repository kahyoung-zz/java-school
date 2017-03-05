package com.example.example.VolatileExample;

/**
 * This method demonstrates how a volatile variable could be used
 *
 * The reason this is needed is because essentially when you make a thread, it stores whatever variables were accessible
 * into its own local cache, and refers to them
 *
 * When you use the volatile keyword, you're telling Java: "Don't use the cached value, go and get the latest value and
 * use that to compare"
 *
 * This link was handy: https://dzone.com/articles/java-volatile-keyword-0
 */
public class VolatileExample {
    private static volatile int INCREMENTOR = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int localValue = 0;

            while(localValue < 5) {
                if (localValue != INCREMENTOR) {
                    System.out.println("INCREMENTOR value " + INCREMENTOR + " differs from localValue " + localValue);
                    localValue = INCREMENTOR;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localValue = INCREMENTOR;

            while (INCREMENTOR < 5) {
                System.out.println("Incrementing INCREMENTOR to " + (localValue + 1));
                INCREMENTOR = ++localValue;

                try {
                    // We use sleep here as we won't need to notify and Threads - means we don't need to keep things happening in CPU
                    // If wanted to make this thread wait until a specific action, then we would use .wait
                    Thread.sleep(500);
                } catch ( InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
