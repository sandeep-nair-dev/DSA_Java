package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_2;

public class P4_2_3_KokoEatingBananas {
    public static int findTotalTime(int[] arr, int speed) {
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            time += Math.ceil((double) arr[i] / (double) speed);
        }
        return time;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        int lo = 1, hi = maxi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int time = findTotalTime(piles, mid);
            if (time <= h) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;          //either return lo, because at end of while loop, hi<lo...otherwise, whenever time<=h, store it in ans and return that
    }

    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minEatingSpeed(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
