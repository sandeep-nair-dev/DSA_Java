package com.sandeep.java_dsa.Algorithms;

public class FloydsCycleDetection {
    public static int floydCycleDetection(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 2};
        int duplicate = floydCycleDetection(arr);
        System.out.println(duplicate);
    }
}
