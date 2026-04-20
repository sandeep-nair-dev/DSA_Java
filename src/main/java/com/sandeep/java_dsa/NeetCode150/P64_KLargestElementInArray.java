package com.sandeep.java_dsa.NeetCode150;

import java.util.PriorityQueue;

public class P64_KLargestElementInArray {

    private static int findKthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
        for(int val: arr){
            if(pq.size()<k){
                pq.offer(val);
            }else if(val>pq.peek()){
                pq.offer(val);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();

    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k=4;
        System.out.println(findKthLargestElement(arr, k));
    }
}
