package com.sandeep.java_dsa.Algorithms;

import java.util.ArrayList;

public class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }

    public static ArrayList<Integer> kadanesAlgorithmWithPrint(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> answer = new ArrayList<>();
        int sum = 0;
        int start = 0, ansStart = 0, ansEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            answer.add(nums[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = kadanesAlgorithm(arr);
        ArrayList<Integer> ansArr = kadanesAlgorithmWithPrint(arr);
        System.out.println("Maximum sum is: " + ans);
        System.out.println("Array with maximum sum: " + ansArr);
    }
}
