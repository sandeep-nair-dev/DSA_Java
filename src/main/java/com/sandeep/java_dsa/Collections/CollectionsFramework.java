package com.sandeep.java_dsa.Collections;

import java.util.*;

public class CollectionsFramework {
    public static void main(String[] args) {
//        listAndIterator();
//        Stack();
//        QueueUsingLinkedList();
//        PriorityQueue();
//        LearnArrayDeque();
//        LearnHashSet();
//        LearnLinkedHashSet();
//        LearnTreeSet();
//        LearnHashMap();
//        LearnTreeMap();
    }

    static void LearnTreeMap() {
        Map<String, Integer> map = new TreeMap<>();  //Now entries sorted based on keys

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        System.out.println(map);

        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("Two"));
        System.out.println(map.containsValue(3));
        if (!map.containsKey("Six")) {
            map.put("Six", 6);
        }
        map.putIfAbsent("Seven", 7);
        map.putIfAbsent("Seven", 99);        // doesnt overwrite the value since entry with key "Seven" already exists
        System.out.println(map);

        map.remove("Five");
        System.out.println(map);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e);
            System.out.println("KEY: " + e.getKey() + " VALUE: " + e.getValue());
        }
        System.out.println("Keys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("Values:");
        for (Integer val : map.values()) {
            System.out.println(val);
        }
    }

    static void LearnHashMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        System.out.println(map);

        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("Two"));
        System.out.println(map.containsValue(3));
        if (!map.containsKey("Six")) {
            map.put("Six", 6);
        }
        map.putIfAbsent("Seven", 7);
        map.putIfAbsent("Seven", 99);        // doesnt overwrite the value since entry with key "Seven" already exists
        System.out.println(map);

        map.remove("Five");
        System.out.println(map);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e);
            System.out.println("KEY: " + e.getKey() + " VALUE: " + e.getValue());
        }
        System.out.println("Keys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("Values:");
        for (Integer val : map.values()) {
            System.out.println(val);
        }
    }

    static void LearnTreeSet() {
        Set<Integer> set = new TreeSet<>();
// in  LinkedHashSet, elements are stored in hash form and also has properties of Binary Search Tree, so elements are in sorted form
        // Time complexity of operations like clear, find, add -> O(logn)
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(5);

        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.remove(5));
        System.out.println(set.contains(5));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }

    static void LearnLinkedHashSet() {
        Set<Integer> set = new LinkedHashSet<>();
// in  LinkedHashSet, elements are stored in hash form and also has properties of linkedlist, so elements are stored in the order they are inputted
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(5);

        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.remove(5));
        System.out.println(set.contains(5));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }

    static void LearnHashSet() {
        Set<Integer> set = new HashSet<>();
// in  hashset, elements are stored in hash form, so in Hashset elements are stored in random order and there is no definite order
        // Time complexity of operations like clear, find, add -> O(1)
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(5);
        set.add(5);

        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.remove(5));
        System.out.println(set.contains(5));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }

    static void Stack() {
        Stack<String> itemStack = new Stack<>();
        itemStack.push("item1");
        itemStack.push("item2");
        itemStack.push("item3");
        itemStack.push("item4");
        itemStack.push("item5");

        System.out.println(itemStack);
        itemStack.add("item6");
        System.out.println(itemStack.peek());
        System.out.println(itemStack.pop());
        System.out.println(itemStack);
    }

    static void QueueUsingLinkedList() {
        // add/offer -> iff unsuccessful, add throws exception but offer just returns false
        // element/peek -> iff unsuccessful, element throws exception but peek just returns false
        // remove/poll -> iff unsuccessful, remove throws exception but poll just returns false
        Queue<String> queue = new LinkedList<>();
        queue.offer("item1");
        queue.offer("item2");
        queue.offer("item3");
        queue.offer("item4");
        queue.offer("item5");
        System.out.println(queue);

        System.out.println(queue.peek());
        queue.add("item6");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    static void LearnArrayDeque() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(33);       // by default adds to last like in queue
        ad.offerFirst(66);
        ad.offerLast(99);
        ad.offer(100);
        System.out.println(ad);

        System.out.println(ad.peek());      // by default peeks front element like in queue
        System.out.println(ad.peekFirst());
        System.out.println(ad.peekLast());

        System.out.println(ad.poll());         // by default removes first element like in queue
        System.out.println(ad);
        System.out.println(ad.pollFirst());
        System.out.println(ad);
        System.out.println(ad.pollLast());
        System.out.println(ad);
    }

    static void PriorityQueue() {
//        Queue<Integer> priorityQueue = new PriorityQueue<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();   //By default implements minheap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());   //Now implements maxheap
        priorityQueue.offer(143);
        priorityQueue.offer(44);
        priorityQueue.offer(57);
        priorityQueue.offer(22);

        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
    }

    static void listAndIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("iterator" + it.next());
        }
    }
}
