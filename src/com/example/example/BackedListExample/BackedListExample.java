package com.example.example.BackedListExample;

import java.util.*;

/**
 * A backed list is a list that 'relies' upon another list
 *
 * I.e. if something changes in List A, it influences List B
 *
 * IMPORTANT: Take note of the {@link java.util.Set#retainAll(Collection)} method being used
 */
public class BackedListExample {
    public static void main(String[] args) {
        Map<String, String> ips = new HashMap<>();
        ips.put("google", "100.0.0.0");
        ips.put("github", "101.0.0.0");
        ips.put("bing", "104.0.0.0");

        System.out.println("All listed IPs");
        System.out.println(ips);

        Map<String, String> searchEngineIps = whitelist(ips, Arrays.asList("google", "bing"));
        System.out.println("Search Engine IPs");
        System.out.println(searchEngineIps);
    }

    private static <K, V> Map<K, V> whitelist(Map<K, V> map, List<K> allowedKeys) {
        Map<K, V> copy = new HashMap<>(map);
        copy.keySet().retainAll(allowedKeys);
        return copy;
    }
}
