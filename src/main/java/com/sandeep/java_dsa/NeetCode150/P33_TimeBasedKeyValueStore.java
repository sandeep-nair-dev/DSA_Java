package com.sandeep.java_dsa.NeetCode150;

import java.util.*;

/**
 * <h5><b>Time Based Key-Value Store</b></h5>
 * <p>
 * Implement a time-based key-value data structure that supports:
 * <ul>
 *     <li>Storing multiple values for the same key at specified timestamps</li>
 *     <li>Retrieving the key's value at a specified timestamp</li>
 * </ul>
 * Implement the {@code TimeMap} class:
 * <ul>
 *     <li>{@code TimeMap()} – Initializes the object.</li>
 *     <li>{@code void set(String key, String value, int timestamp)} – Stores the {@code key} with the {@code value} at the given {@code timestamp}.</li>
 *     <li>{@code String get(String key, int timestamp)} – Returns the most recent {@code value} of {@code key} such that its timestamp is less than
 *     or equal to the given {@code timestamp} (i.e., {@code prev_timestamp <= timestamp}). If no such value exists, returns an empty string {@code ""}.</li>
 * </ul>
 * <b>Note:</b> For all calls to {@code set}, the {@code timestamp}s are strictly increasing.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]}<br>
 * Output: {@code [null, null, "happy", "happy", null, "sad"]}
 * <br><br>
 * Explanation:<br>
 * {@code TimeMap timeMap = new TimeMap();}<br>
 * {@code timeMap.set("alice", "happy", 1);}  // stores the key "alice" and value "happy" with timestamp 1<br>
 * {@code timeMap.get("alice", 1);}           // returns "happy"<br>
 * {@code timeMap.get("alice", 2);}           // returns "happy", no value at timestamp 2, so use value at timestamp 1<br>
 * {@code timeMap.set("alice", "sad", 3);}    // stores the key "alice" and value "sad" with timestamp 3<br>
 * {@code timeMap.get("alice", 3);}           // returns "sad"
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= key.length, value.length <= 100}<br>
 * {@code key} and {@code value} contain only lowercase English letters and digits<br>
 * {@code 1 <= timestamp <= 1000}
 */

public class P33_TimeBasedKeyValueStore {
    /*
    Soln1
     */
    class TimeMap {
        class Pair {
            String key;
            Integer value;

            Pair(String key, int value) {
                this.key = key;
                this.value = value;
            }

            String getKey() {
                return this.key;
            }

            int getValue() {
                return this.value;
            }
        }

        HashMap<String, List<Pair>> timeMap;

        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (timeMap.containsKey(key)) {
                timeMap.get(key).add(new Pair(value, timestamp));
            } else {
                List<Pair> val = new ArrayList<>();
                val.add(new Pair(value, timestamp));
                timeMap.put(key, val);
            }
        }

        public String get(String key, int timestamp) {
            List<Pair> pairs = timeMap.getOrDefault(key, new ArrayList<>());
            int lo = 0;
            int hi = pairs.size() - 1;
            String result = "";
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                Pair midElement = pairs.get(mid);
                if (midElement.getValue() <= timestamp) {
                    result = midElement.getKey();
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return result;
        }
    }

    /*
    Soln 2
     */
    class TimeMap2 {
        private Map<String, TreeMap<Integer, String>> map;

        public TimeMap2() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";
            TreeMap<Integer, String> treeMap = map.get(key);
            Map.Entry<Integer, String> floorEntry = treeMap.floorEntry(timestamp);
            return floorEntry!=null?floorEntry.getValue():"";
        }
    }
}
