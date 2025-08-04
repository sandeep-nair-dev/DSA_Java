package com.sandeep.java_dsa.NeetCode150;

public class P42_FindTheDuplicateNumber {
    private static int findDuplicate(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2};
        System.out.println("Duplicate element: " + findDuplicate(arr));
    }
}
