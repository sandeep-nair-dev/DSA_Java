package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.Arrays;

public class P_3_3_8_MergeSortedArrays {
    // Leetcode problem is a bit different. In this we want to have the 2 arrays a and b and we want it sorted from a to b, numbers should be in non-decreasing order from 0 to a.size to 0 to b.size. Optimally without using extra space
    /*
        Brute Force: Use a third Array. store the sorted array in third array and then copy all elements from third to first
        TC -> O(m+n) + O(m+n)
        SC -> O(m+n)
     */

    /*
        Optimal Way 1
        TC -> O(min(m,n)) + O(nlogn) + O(mlogm)
        SC -> O(1)
     */
    private static void optimalMethod1(int[] a, int[] b, int m, int n) {
        int i = m - 1, j = 0;
        while (i >= 0 || j < n) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    /*
        Optimal Way 2: GAP Method
       TC -> O(log(m+n)) * O(m+n)
       SC -> O(1)
     */
    private static void gapMethod(int[] arr1, int[] arr2, int m, int n) {
        int length = m + n;
        int gap = Math.ceilDivExact(length, 2);
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < length) {
                if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                } else if (left >= m) {
                    swapIfGreater(arr1, arr2, left - m, right - m);
                } else {
                    swapIfGreater(arr1, arr2, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = Math.ceilDivExact(gap, 2);
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
//        optimalMethod1(arr1, arr2, m, n);
        gapMethod(arr1, arr2, m,n);
        System.out.println(Arrays.toString(arr1) + " ---" + Arrays.toString(arr2));

    }
}
