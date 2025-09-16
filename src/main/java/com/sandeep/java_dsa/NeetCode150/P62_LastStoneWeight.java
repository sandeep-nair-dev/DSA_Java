package com.sandeep.java_dsa.NeetCode150;

import java.util.PriorityQueue;

public class P62_LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int top1 = pq.poll();
            if (!pq.isEmpty()) {
                int top2 = pq.poll();
                int absDiff = Math.abs(top1 - top2);
                pq.offer(absDiff);
            }
        }
        return !pq.isEmpty() ? pq.poll() : -1;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
}
