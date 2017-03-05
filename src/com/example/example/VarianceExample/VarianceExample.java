package com.example.example.VarianceExample;

import java.util.Arrays;
import java.util.List;

/**
 * This example illustrates the difference and importance between different type parameters
 *
 * E.g. List<String> or List<? extends Number>
 *
 * It's useful because we can be stricter in terms of what our methods return and ensure that no matter how many other
 * people use our methods, we can ensure that they know what the method expects, and can assume the right data type for
 * the response
 *
 * Here's a good link about variance:
 *
 * http://stackoverflow.com/questions/2501023/demonstrate-covariance-and-contravariance-in-java
 *
 * Simpler terms:
 * Covariance - when you're doing something to an object that's a subtype of a class
 * Contravariance - when you're doing something to an object that's a superclass of a class
 */
public class VarianceExample {
    public static void main(String[] args) {

        // Covariance
        System.out.println(covariantSum(Arrays.asList(1L, 3L, 4L)));
        System.out.println(covariantSum(Arrays.asList(1, 3, 4)));

        // Contravariance
        printCovariants(Arrays.asList("String", "One"));
    }

    /**
     * A covariant example
     *
     * This method is here to show us that we can create a method that only accepts data types that are an extension of
     * {@link Number}
     *
     * @param numbers The list of numbers to sum
     * @return double The resulting sum
     */
    private static double covariantSum(List<? extends Number> numbers) {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    /**
     * A contravariant example
     *
     * This method is here to show us that we can create a method that only accepts the super class of a given type
     *
     * This could be useful when we're comparing items, and we want to write a compare method within class A (which is
     * a subtype of class B)
     *
     * For example:
     *
     * <T> void sort(List<T> list, Comparator<? super T> c)
     *
     * This allows our comparator to not only compare type T but also any other classes that extend the superclass of T
     *
     * @param numbers The list of numbers to sum
     */
    private static void printCovariants(List<? super Long> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }
}
