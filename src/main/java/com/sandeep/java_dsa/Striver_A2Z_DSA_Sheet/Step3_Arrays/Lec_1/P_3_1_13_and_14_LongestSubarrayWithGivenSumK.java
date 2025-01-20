package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_1;

import java.util.HashMap;
import java.util.Map;

public class P_3_1_13_and_14_LongestSubarrayWithGivenSumK {

    // best solution if 0 or negative is present
    public static int betterSolution(int[] a, long k) {
        // Write your code here
        int n = a.length;
        int maxlen = 0;
        long sum = 0L;
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }
            Long rem = sum - k;
            if (prefixSumMap.containsKey(rem)) {
                maxlen = Math.max(maxlen, i - prefixSumMap.get(rem));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return maxlen;
    }

    // works only in case of positive elements and fails if there is 0 or negative
    public static int optimalSolution(int[] a, long k) {
        int n = a.length;
        int i = 0, j = 0;
        long sum = a[0];
        int len = 0;
        while (j < n) {
            while (i <= j && sum > k) {
                sum -= a[i];
                i++;
            }
            if (sum == k) {
                len = Math.max(len, j - i + 1);
            }
            j++;
            if (j < n) sum += a[j];
        }
        return len;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;
        int longest2 = betterSolution(a, k);
        int longest3 = optimalSolution(a, k);
        System.out.println(longest2);
        System.out.println(longest3);
    }
}
