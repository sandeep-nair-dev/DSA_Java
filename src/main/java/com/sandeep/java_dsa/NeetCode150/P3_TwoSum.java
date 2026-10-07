package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;
import java.util.HashMap;

public class P3_TwoSum {

    static int[] twoSum(int[] nums, int target) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == target) break;
            else if (sum < target) lo++;
            else hi--;
        }

        int[] res = new int[2];
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==arr[lo]||nums[i]==arr[hi]){
                res[pos]=i;
                pos++;
            }
        }
        return res;
    }

    static int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff) && map.get(diff)!=i){
                return new int[]{i, map.get(diff)};
            }
        }

        return new int[]{0};
    }

    static int[] twoSumOptimal(int[] nums, int target){
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff),i};
            }
            prevMap.put(nums[i],i);
        }
        return new int[]{0};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] sol = twoSumOptimal(nums, 6);
        System.out.println("["+sol[0] + "," + sol[1]+"]");
    }
}
