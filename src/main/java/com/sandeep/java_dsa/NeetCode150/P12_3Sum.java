package com.sandeep.java_dsa.NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0) break;        // since array is sorted and ith element is +ve that means, all elements ahead are also +ve, which means no triplet from here onward could make 0 sum
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) j++;
                else k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Optimal Method: " + threeSum(arr));
    }
}
