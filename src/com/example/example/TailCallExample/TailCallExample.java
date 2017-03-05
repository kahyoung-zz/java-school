package com.example.example.TailCallExample;

/**
 * Okay, so what is Tail Call?
 *
 * A tail call is when a method's return statement is another function call
 *
 * i.e.
 *
 * func a() {
 *     return b();
 * }
 *
 * The reason why this is important is when we get to recursive functions - where the last line of the function is a
 * call to the same function. The reason why tail call is important in Java is because Java does not optimize tail
 * calls. What it will do is prepare the stack to call the tail function, execute the tail function, and bubble
 * that result all the way back up to the original call
 *
 * An optimized tail call would just act as a 'goto' i.e. just keep passing the values further down the chain and only
 * return the result
 *
 * Since Java doesn't optimize tail calls, it's sometimes better to re-write recursive functions as loops
 *
 * Here's a helpful link: https://www.quora.com/What-is-tail-recursion-Why-is-it-so-bad
 */
@SuppressWarnings("SameParameterValue")
public class TailCallExample {
    public static void main(String[] args) {
        System.out.println(TailCallExample.sumFromOneToNRecursive(9999));
        System.out.println(TailCallExample.sumFromOneToNTail(9999, 0));
        System.out.println(TailCallExample.sumFromOneToNIterative(9999));
    }

    /**
     * This is a basic recursive function - it is not a tail call as it isn't _just_ calling itself at the end; it's adding
     * n to the value
     * @param n The limit we want to sum to
     * @return int The resulting sum
     */
    private static int sumFromOneToNRecursive(int n) {
        if (n < 1) {
            return 0;
        }

        return n + sumFromOneToNRecursive(n - 1);
    }

    /**
     * This is a tail call function - it's calling itself at the very last line. It'll do the _roughly_ the same thing as
     * the previous function (assuming a = 0)
     *
     * @param n The limit we want to sum to
     * @param a The beginning number
     * @return int The resulting sum
     */
    private static int sumFromOneToNTail(int n, int a) {
        if (n < 1) {
            return a;
        }

        return sumFromOneToNTail(n - 1, a + n);
    }

    /**
     * This is the basic recursive function converted into a loop
     *
     * This is optimized, as it doesn't require all the preparation and bubbling that occurs during recursive functions /tail calls
     *
     * @param n The limit we want to sum to
     * @return int The resulting sum
     */
    private static int sumFromOneToNIterative(int n) {
        int a = 0;

        while(n > 0) {
            a += n--;
        }

        return a;
    }
}
