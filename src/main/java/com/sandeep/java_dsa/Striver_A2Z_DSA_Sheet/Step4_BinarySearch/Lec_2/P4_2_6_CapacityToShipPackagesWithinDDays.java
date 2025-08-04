package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_2;

public class P4_2_6_CapacityToShipPackagesWithinDDays {


    /**
     * Optimal solution
     * TC-> O(N * log(sum(weights[]) - max(weights[]))   where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
     * Reason: We are applying binary search on the range [max(weights[]), sum(weights[])]. For every possible answer ‘mid’, we are calling findDays() function. Now, inside the findDays() function, we are using a loop that runs for N times.
     * SC -> O(1)
     */
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalWeights = 0;
        int ans = Integer.MAX_VALUE;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeights += weight;
        }

        int lo = maxWeight, hi = totalWeights;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int day = 1;
            int sumOfWeights = 0;
            for (int i = 0; i < weights.length; i++) {
                if (sumOfWeights + weights[i] <= mid) {
                    sumOfWeights += weights[i];
                } else {
                    day++;
                    sumOfWeights = weights[i];
                }
            }

            if (day <= days) {
                ans = Math.min(mid, ans);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3, 3, 3, 3, 3, 3};
        int days = 2;
        System.out.println(shipWithinDays(weights, days));
    }
}
