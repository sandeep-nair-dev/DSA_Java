package com.sandeep.java_dsa.NeetCode150;

/**
 * <h3>Problem Statement</h3>
 * <p>
 *  You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times.
 *  <p>
 *  For example, the array nums = [1,2,3,4,5,6] might become:
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * <p>
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 * You may assume all elements in the sorted rotated array nums are unique,
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 * <p>
 * Example 1:   <br>
 * Input: nums = [3,4,5,6,1,2], target = 1  <br>
 * Output: 4
 * <p>
 * Example 2:   <br>
 * Input: nums = [3,5,6,0,1,2], target = 4  <br>
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000   <br>
 * -1000 <= nums[i] <= 1000   <br>
 * -1000 <= target <= 1000    <br>
 */
public class P32_SearchInRotatedSortedArray {

    /*One solution is to find the pivot index, and run binary search on left or right sorted array
     eg. for 3, 4, 5, 6, 1, 2...we find the pivot is 1, so if
        target >= arr[0] and target <= arr[pivot-1] we apply binary search in left array
        otherwise we apply in right array
     */

    private static int solutionBinarySearchTwoPass(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int pivot = lo;
        lo = 0;
        hi = arr.length - 1;

        if (target >= arr[pivot] && target <= arr[hi]) {
            lo = pivot;
        } else {
            hi = pivot - 1;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    /*
        Optimal Solution
     */
    private static int findIndex(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] >= arr[lo]) {
                if (target > arr[mid] || target < arr[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target > arr[hi] || target < arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,1,2};
        int target = 3;

        System.out.println(solutionBinarySearchTwoPass(arr, target));
        System.out.println(findIndex(arr, target));
    }
}
