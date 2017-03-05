package com.example.example.CopyOnWriteArrayListExample;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class demonstrates how you could use a {@link CopyOnWriteArrayList} to modify a list while iterating
 *
 * For more information, check the JavaDocs https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html
 */
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Test");

        for (String item : list) {
            if (item.equals("Test")) {
                list.add("Hello");
            }
        }

        System.out.println(list);
    }
}
