package com.example.example.ThreadLocalExample;

/**
 * Main class that runs the example for LocalThreads
 *
 * This is pretty much a dumbed down version on how threads are 'global' yet hold their own local values
 *
 * For more information check the JavaDocs http://docs.oracle.com/javase/7/docs/api/java/lang/ThreadLocal.html
 */
public class ThreadExample extends Thread {

    public static void main(String[] args) {
        Thread threadOne = new ThreadExample();
        threadOne.start();

        Thread threadTwo = new ThreadExample();
        threadTwo.start();
    }

    @Override
    public void run() {
        ExternalAccess externalAccess = new ExternalAccess();
        System.out.println("Thread Number: " + ThreadId.get());
        externalAccess.printThreadId();
    }
}
