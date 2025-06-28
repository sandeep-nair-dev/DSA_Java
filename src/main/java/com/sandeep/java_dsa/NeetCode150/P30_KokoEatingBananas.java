package com.sandeep.java_dsa.NeetCode150;

public class P30_KokoEatingBananas {

    private static int findHoursTaken(int[] piles, int speed) {
        int hours = 0;
        for (int bananas : piles) {
            hours += (int)Math.ceil((double)bananas/speed);
        }
        return hours;
    }

    private static int findBananasPerHour(int[] piles, int hours) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        int ans = 0;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int hoursTaken = findHoursTaken(piles, mid);
            if (hoursTaken <= hours) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{25, 10, 23, 4};
        int hours = 4;
        System.out.println("Bananas per hour: " + findBananasPerHour(piles, hours));
    }
}
