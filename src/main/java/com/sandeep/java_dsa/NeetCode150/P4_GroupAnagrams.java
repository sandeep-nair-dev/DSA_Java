package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 *  * <h3><b>Problem Statement....Leetcode 49</b></h3>
 */
public class P4_GroupAnagrams {
    /*
        My Soln:
        TC-> O(n *mlogm)
        SC-> O(n)
     */
    private static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        Arrays.stream(arr).forEach(t -> {
            char[] charArray = t.toCharArray();
            Arrays.sort(charArray);
            String sortedString = Arrays.toString(charArray);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(t);
            } else {
                map.put(sortedString, new ArrayList<>(Arrays.asList(t)));
            }
        });
        map.forEach((key, value) -> result.add(value.stream().toList()));
        return result;
    }

    /*
        Optimal Solution:
            TC -> O(n*m)
            SC -> O(n*m)
     */
    private static List<List<String>> groupAnagramsOptimal(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();
        Arrays.stream(arr).forEach(s -> {
            int[] count = new int[26];
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
//            StringBuilder frequencyStringBuilder = new StringBuilder();
//            for (int i = 0; i < count.length; i++) {
//                if (count[i] > 0) {
//                    frequencyStringBuilder.append((char) ('a' + i));
//                    frequencyStringBuilder.append(count[i]);
//                }
//            }
//            String key = frequencyStringBuilder.toString();
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        });
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsOptimal(strs));
    }
}
