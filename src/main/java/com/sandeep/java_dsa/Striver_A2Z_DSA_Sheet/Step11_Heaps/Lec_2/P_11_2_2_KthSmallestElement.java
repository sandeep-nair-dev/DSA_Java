package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step11_Heaps.Lec_2;

import java.util.PriorityQueue;

public class P_11_2_2_KthSmallestElement {
    static int findKthSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (a-b));
        for(int i: arr){
            pq.offer(i);
        }
        for(int i=0;i<k-1;i++){
            pq.remove();
        }
        return !pq.isEmpty()?pq.poll():-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthSmallestElement(arr, k));
    }
}
