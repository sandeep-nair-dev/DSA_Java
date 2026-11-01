package com.sandeep.java_dsa.NeetCode150;

import java.util.Queue;

public class P42_FindTheDuplicateNumber {

    // mark visited as index, so if its duplicate exists, we will visit again and when we see it is already -ve, we know this is the duplicate
    // TC -> O(n)
    // SC -> O(1)
    public int findDuplicate(int[] nums) {
        for(int num: nums){
            int index=Math.abs(num)-1;
            if(nums[index]<0){
                return Math.abs(num);
            }
            nums[index]*=-1;
        }
        return -1;
    }

    // TC-> O(n)
    // SC -> O(1)
    private static int findDuplicate_ll(int[] arr){
        int slow=0, fast=0;
        do{
            fast = arr[arr[fast]];
            slow = arr[slow];
        }while (slow!=fast);

        slow=0;
        while (slow != fast){
            fast = arr[fast];
            slow = arr[slow];
        }
        return slow;
    }

    static class LRUCache {



        public LRUCache(int capacity) {

        }

        public int get(int key) {

        }

        public void put(int key, int value) {

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2};
        System.out.println("Duplicate element: " + findDuplicate_ll(arr));
    }
}
