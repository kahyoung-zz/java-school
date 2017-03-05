package com.example.example.UncaughtExceptionHandlerExample;

/**
 * This is an example of how you could handle errors that occur in another Thread
 */
public class UncaughtExceptionHandlerExample {
    @SuppressWarnings({"Convert2Lambda", "unused", "AnonymousHasLambdaAlternative"})
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Uh oh, we've got an error!: " + e);
            }
        };

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread is sleeping...");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Thread's sleep!");
                }

                System.out.println("Throwing an exception...");
                throw new RuntimeException("This is normal! Don't fret");
            }
        };

        // If we leave this next line commented out, then we'll get an angry unhandled error
        // Otherwise, we can handle it nicely in our handler
//        thread.setUncaughtExceptionHandler(handler);
        thread.start();
    }
}
