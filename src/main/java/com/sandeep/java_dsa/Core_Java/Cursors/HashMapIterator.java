package com.sandeep.java_dsa.Core_Java.Cursors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);

        System.out.println(map.keySet());

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println("--------------------------------------------------------");

        Iterator<Map.Entry<String, Integer>> eiterator = map.entrySet().iterator();

        while (eiterator.hasNext()) {
            Map.Entry<String, Integer> cur = eiterator.next();
            System.out.println(cur.getKey() + " : " + cur.getValue());
        }
    }
}
