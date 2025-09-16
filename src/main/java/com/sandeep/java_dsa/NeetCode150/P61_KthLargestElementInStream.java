package com.sandeep.java_dsa.NeetCode150;

import java.util.PriorityQueue;

public class P61_KthLargestElementInStream {
    int count;
    PriorityQueue<Integer> pq;

    public P61_KthLargestElementInStream(int k, int[] nums) {
        count = k;
        pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.offer(num);
                if (pq.size() > k)
                    pq.poll();
            }
        }
    }

    public int add(int val) {
        if (pq.size() < count)
            pq.offer(val);
        else if (val > pq.peek()) {
            pq.offer(val);
            if (pq.size() > count) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
