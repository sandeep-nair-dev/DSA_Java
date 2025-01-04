package com.sandeep.java_dsa.Problems;

import java.util.Arrays;

public class Sort012 {
    //Uses Dutch Flag Algorithm


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2, 2, 1, 1, 0, 2, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }
    }
}
