package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Longest Consecutive Sequence in an Array
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.
 */
public class P_3_2_10_LongestConsequenceSequence {

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
//        int[] a = {3, 8, 5, 7, 6};
        int betterAns = betterLongestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + betterAns);
        System.out.println("---------------------------------");
        int optimalAns = optimalLongestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + optimalAns);
    }

    /*
        Optimal Solution: Only if the map is unordered, dont have collisions hence take O(1) time to find. If It has collisions and take O(N) then it take log n and here betterSoln becomes better than this
        Considering it takes O(1) to find, and no collisions
            TC -> O(N) + O(2N)
            SC -> O(N)
     */
    private static int optimalLongestSuccessiveElements(int[] a) {
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for (int i : a) {
            set.add(i);
        }
        for (Integer it : set) {
            if (!set.contains(it - 1)) {
                int count = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    /*
        Better Solution:
            TC -> O(nlogn) + O(n)
            SC -> O(1);
     */
    private static int betterLongestSuccessiveElements(int[] a) {
        Arrays.sort(a);
        int maxi = 1;
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxi) maxi = count;
        }
        return maxi;
    }
}
