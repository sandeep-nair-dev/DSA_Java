package com.sandeep.java_dsa.NeetCode150;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h5><b>LRU Cache</b></h5>
 * <p>
 * Implement the Least Recently Used (LRU) cache class {@code LRUCache}. The class should support the following operations:
 * <ul>
 *     <li>{@code LRUCache(int capacity)} – Initialize the LRU cache of size {@code capacity}.</li>
 *     <li>{@code int get(int key)} – Return the value corresponding to the {@code key} if it exists, otherwise return {@code -1}.</li>
 *     <li>{@code void put(int key, int value)} – Update the value of the {@code key} if it exists. Otherwise, add the key-value pair to the cache.
 *     If the cache exceeds its capacity, remove the least recently used key.</li>
 * </ul>
 * A key is considered "used" if a {@code get} or {@code put} operation is called on it.
 * <p>
 * All operations must run in average {@code O(1)} time complexity.
 * <p>
 * <b>Example 1:</b><br>
 * Input: {@code ["LRUCache", [2], "put", [1, 10], "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]}<br>
 * Output: {@code [null, null, 10, null, null, 20, -1]}<br>
 * <br>
 * Explanation:<br>
 * {@code LRUCache lRUCache = new LRUCache(2);}<br>
 * {@code lRUCache.put(1, 10);  // cache: {1=10}}<br>
 * {@code lRUCache.get(1);      // returns 10}<br>
 * {@code lRUCache.put(2, 20);  // cache: {1=10, 2=20}}<br>
 * {@code lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted}<br>
 * {@code lRUCache.get(2);      // returns 20}<br>
 * {@code lRUCache.get(1);      // returns -1 (not found)}
 * <p>
 * <b>Constraints:</b><br>
 * {@code 1 <= capacity <= 100}<br>
 * {@code 0 <= key <= 1000}<br>
 * {@code 0 <= value <= 1000}
 */

public class P43_LRUCache {
    /**
     * Solution 1
     * Using Doubly Linked List
     * TC -> O(1) for get and put
     * SC -> O(n)
     */
    class LRUCacheSolution1 {
        class CacheNode {
            int key;
            int val;
            CacheNode prev;
            CacheNode next;


            public CacheNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        private HashMap<Integer, CacheNode> cache;
        private CacheNode left;
        private CacheNode right;

        public LRUCacheSolution1(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            this.left = new CacheNode(0, 0);
            this.right = new CacheNode(0, 0);
            this.left.next = right;
            this.right.prev = left;
        }

        private void remove(CacheNode node) {
            CacheNode prev = node.prev;
            CacheNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insert(CacheNode node) {
            CacheNode currentMostRecentlyUsed = this.right.prev;
            currentMostRecentlyUsed.next = node;
            node.prev = currentMostRecentlyUsed;
            node.next = this.right;
            this.right.prev = node;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                CacheNode curr = cache.get(key);
                remove(curr);
                insert(curr);
                return curr.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                remove(cache.get(key));
            }
            CacheNode newNode = new CacheNode(key, value);
            cache.put(key, newNode);
            insert(newNode);

            if (cache.size() > capacity) {
                CacheNode leastRecentlyUsed = this.left.next;
                remove(leastRecentlyUsed);
                cache.remove(leastRecentlyUsed.key);
            }
        }
    }

    /**
     * Solution 2
     * Using Arraylist
     * TC -> O(n) for get and put
     * SC -> O(n)
     */
    class LRUCacheSolution2{
        //TODO: Implement
    }



        /**
     * Solution 3
     * Using built-in data structure
     */
    class LRUCacheSolution3{
        private final Map<Integer, Integer> cache;
        private final int capacity;

        public LRUCacheSolution3(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                    return size()>LRUCacheSolution3.this.capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value){
            cache.put(key, value);
        }
    }
}
