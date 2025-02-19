package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step5_Strings.Lec_2;

import java.util.*;

public class P_5_2_1_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((ob1, ob2) -> map.get(ob2) - map.get(ob1));

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                ans.append(ch);
            }
            // or ans.append(String.valueOf(ch).repeat(Math.max(0, map.get(ch))));
        }
        return ans.toString();
    }

    public static String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        priorityQueue.addAll(map.entrySet());

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            stringBuilder.append(String.valueOf(poll.getKey()).repeat(poll.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort2("tree"));
    }
}
