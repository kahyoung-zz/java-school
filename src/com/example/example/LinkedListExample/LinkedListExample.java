package com.example.example.LinkedListExample;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * This class is here to demonstrate the benefits of using a {@link LinkedList} compared to, say, an {@link ArrayList}
 * or a {@link Vector}
 *
 * In short, a Linked List is doubly linked
 *
 * This means that LinkedList would use more memory, but when adding/removing items at a specific index, it is faster
 * and more efficient.
 *
 * When adding/removing at an index, LinkedList only needs to update the item before and after the given index (O(1))
 * On an array list, the list needs to update every item after the index (O(n) at worst if removing/adding first)
 *
 */
public class LinkedListExample {
    public static void main(String[] args) {
        // An array list will have to shift every item after the given index forward by one
        List<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("five");
        arrayList.add(1, "two");
        arrayList.add(2, "three");
        arrayList.add(3, "four");
        System.out.println(arrayList);

        // A linkedList is doubly linked - this allows us to only need to shift the item before and after the inserted/removed element
        List<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("five");
        linkedList.add(1, "two");
        linkedList.add(2, "three");
        linkedList.add(3, "four");
        System.out.println(linkedList);
    }
}
