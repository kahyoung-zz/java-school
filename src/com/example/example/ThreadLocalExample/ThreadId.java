package com.example.example.ThreadLocalExample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class holds the .get method which will generate a new Integer within a thread
 */
@SuppressWarnings("AnonymousHasLambdaAlternative")
class ThreadId {
    // Next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    static int get() {
        return threadId.get();
    }
}
