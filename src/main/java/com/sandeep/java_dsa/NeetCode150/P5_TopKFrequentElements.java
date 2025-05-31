package com.sandeep.java_dsa.NeetCode150;


import java.util.*;

/**
 * <h3><b>Problem Statement....Leetcode 347</b></h3>
 * <p>Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.<br><br>
 * <p>
 * Example 1:<br>
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2<br>
 * Output: [1,2]<br><br>
 * <p>
 * Example 2:<br>
 * Input: nums = [1], k = 1<br>
 * Output: [1]<br>
 * </p>
 */
public class P5_TopKFrequentElements {

    /*
        Using map and sorting
        TC-> O(n*logn)
        SC -> O(n)
     */
    public static int[] findTopKFrequent(int[] arr, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        freq.forEach((key, value) -> res.add(new int[]{value, key}));
        res.sort((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            result[i] = res.get(i)[1];
        }
        return result;
    }

    /*
            Using MinHeap
            TC-> O(n*logk)
            SC -> O(n+k)
     */
    public static int[] findTopKFrequentUsingMinHeap(int[] arr, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        freq.forEach((key, value) -> {
            heap.offer(new int[]{value, key});
            if (heap.size() > k) heap.poll();
        });

        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(heap.poll())[1];
        }
        return result;
    }

    /*
            Using BucketSort
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        System.out.println("Using map and sorting: " + Arrays.toString(findTopKFrequent(nums, 2)));
        System.out.println("Using minheap: " + Arrays.toString(findTopKFrequentUsingMinHeap(nums, 2)));
    }
}
