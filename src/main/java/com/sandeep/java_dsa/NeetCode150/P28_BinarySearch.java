package com.sandeep.java_dsa.NeetCode150;

public class P28_BinarySearch {
    static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    //Finds the first value greater than target, then checks if value before equals target or not
    static int searchUsingUpperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (lo > 0 && nums[lo - 1] == target) ? lo - 1 : -1;
    }

    /*
    Lower bound binary search finds the first index where a value is greater than or equal to the target.
    This means if the target exists in the array, this lower-bound index will point exactly to its first occurrence.
    So instead of directly searching for equality, we search for the leftmost position where the target could appear, then verify it.
     */
    static int searchUsingLowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l < nums.length && nums[l] == target) ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
        System.out.println(searchUsingUpperBound(new int[]{-1, 0, 3, 5, 9, 12}, 10));
    }
}
