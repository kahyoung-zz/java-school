package com.example.example.SetExample;

import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This example is used primarily to demonstrate the differences between HashSets and TreeSets
 *
 * Generally, HashSets are faster, but TreeSets are important when the order of the items matter (as you can specify
 * the order by the comparator) or querying for a range of elements
 *
 * Check out the JavaDocs for more information:
 * http://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html#tailSet(E)
 */
public class SetExample {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        HashSet<Event> hashSet = new HashSet<>();

        // Adding 3 events that occurred on 2016-05-15 nad 3 events that occured on 2017-05-15
        hashSet.add(new Event(1463234400000L));
        hashSet.add(new Event(1494770400000L));
        hashSet.add(new Event(1463234400000L));
        hashSet.add(new Event(1494770400000L));
        hashSet.add(new Event(1463234400000L));
        hashSet.add(new Event(1494770400000L));

        System.out.println("Unfiltered HashSet size " + hashSet.size());

        // If we only wanted events that happened in 2017, we'd need to iterate through each item, and compare
        HashSet<Event> filteredSet = new HashSet<>();
        for (Event event : hashSet) {
            if (event.compare(event, new Event(1483189200000L)) >= 0) {
                filteredSet.add(event);
            }
        }

        System.out.println("Filtered HashSet length " + filteredSet.size());

        // Now let's compare that with a tree set - if you check the constructor, you could pass your own comparator
        SortedSet<Event> treeSet = new TreeSet<>(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Long.compare(o1.timestamp, o2.timestamp);
            }
        });

        /*
          IMPORTANT: You may notice that each timestamp has an extra MS
          This is because, when TreeSet is using the Comparator to determine uniqueness, it's looking at the actual
          timestamp value, not the instance of the event. If the comparator determines that the events are the same,
          then it automatically gets stripped

          If we had not put the extra MS, then we'd only have 2 items in the list
         */
        treeSet.add(new Event(1463234400000L));
        treeSet.add(new Event(1494770400000L));
        treeSet.add(new Event(1463234400001L));
        treeSet.add(new Event(1494770400001L));
        treeSet.add(new Event(1463234400002L));
        treeSet.add(new Event(1494770400002L));

        System.out.println("Unfiltered Tree Set Size " + treeSet.size());
        System.out.println("Filtered Tree Set Size " + treeSet.tailSet(new Event(1483189200000L)).size());
    }

    static class Event implements Comparator<Event> {
        private final long timestamp;

        Event(long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public int compare(Event o1, Event o2) {
            return Long.compare(o1.timestamp, o2.timestamp);
        }
    }
}
