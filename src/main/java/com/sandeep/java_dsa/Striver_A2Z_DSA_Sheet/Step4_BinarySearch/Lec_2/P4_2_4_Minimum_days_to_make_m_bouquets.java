package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_2;

public class P4_2_4_Minimum_days_to_make_m_bouquets {
    public static boolean checkBloom(int[] bloomDay, int m, int k, int day) {
        boolean[] arr = new boolean[bloomDay.length];
        int adj = 0;
        int adjCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                adj++;
            } else {
                adjCount += (adj / k);
                adj = 0;
            }
        }
        adjCount += adj / k;
        return adjCount >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n / k < m) return -1;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
            mini = Math.min(mini, bloomDay[i]);
        }
        int lo = mini, hi = maxi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (checkBloom(bloomDay, m, k, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}
