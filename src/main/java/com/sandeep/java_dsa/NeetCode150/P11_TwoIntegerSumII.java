package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;

public class P11_TwoIntegerSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int lo=0, hi=numbers.length-1;
        while(lo<=hi){
            int sum = numbers[lo]+numbers[hi];
            if(sum==target) return new int[]{lo+1,hi+1};
            else if (sum<target) lo++;
            else hi--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int target=3;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
