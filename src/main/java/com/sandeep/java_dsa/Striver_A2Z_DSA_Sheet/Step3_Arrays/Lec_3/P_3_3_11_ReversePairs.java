package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;


import java.util.ArrayList;
import java.util.List;

/**
 * <h3><b>Problem Statement</b></h3>
 * <p>Given an integer array nums, return the number of reverse pairs in the array.<br>
 * A reverse pair is a pair (i, j) where:<br>
 * 0 <= i < j < nums.length and <br>
 * nums[i] > 2 * nums[j].</p>
 *
 * <p> Example 1:<br>
 * Input: nums = [1,3,2,3,1]<br>
 * Output: 2<br>
 * Explanation: The reverse pairs are:<br>
 * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1<br>
 * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1<br>
 * </p>
 */
public class P_3_3_11_ReversePairs {

    private static int reversePairsBruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (2 * arr[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        List<Integer> temp = new ArrayList<>();
        int left = lo, right = mid + 1;
        while (left <= mid && right <= hi) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= hi) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = lo; i <= hi; i++) {
            arr[i] = temp.get(i - lo);
        }
    }

    private static int countPairs(int[] arr, int lo, int mid, int hi) {
        int count = 0, right = mid + 1;
        for (int left = lo; left <= mid; left++) {
            while (right <= hi && (double)arr[left]/2 > (double)arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    private static int mergeSort(int[] arr, int lo, int hi) {
        int count = 0;
        if (lo >= hi) return count;
        int mid = (lo + hi) / 2;
        count += mergeSort(arr, lo, mid);
        count += mergeSort(arr, mid + 1, hi);
        count += countPairs(arr, lo, mid, hi);
        merge(arr, lo, mid, hi);
        return count;
    }

    /**
     *  <b>Optimal Solution:</b><br>
     *  TC -> O(logn) + O(n{merge} + (n1+n2){countPairs})       countPairs is not O(n1*n2) because for each n1, we go to particular right and for next i resume at that right...so basically it is O(n1+n2), i.e., O(n) i.e., similar to merge operation<br>
     *      Therefore effective TC -> O(2nLogn)             <br>
     *  SC -> O(n)      {temporary array for storing}       <br>
     *
     *  <br>
     *         Here we are sorting too so end up distorting the array, if we want to not distort the array, we'd have to take a copy of the array and perform on that.<br><br>
     *
     *         <b>Approach:</b>
     *      The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just a one-line addition inside the merge() function. Inside the merge(), we need to add the number of pairs to the count when a[left] > a[right].<br>
     *
     * The steps of the merge() function were the following:
     *<ul>
     * <li>In the merge function, we will use a temp array to store the elements of the two sorted arrays after merging. Here, the range of the left array is low to mid and the range for the right half is mid+1 to high.</li>
     * <li>Now we will take two pointers left and right, where left starts from low and right starts from mid+1.</li>
     * <li>Using a while loop( while(left <= mid && right <= high)), we will select two elements, one from each half, and will consider the smallest one among the two. Then, we will insert the smallest element in the temp array.</li>
     * <li>After that, the left-out elements in both halves will be copied as it is into the temp array.</li>
     * <li>Now, we will just transfer the elements of the temp array to the range low to high in the original array.</li>
     * <br><br>
     *
     *
     * Modifications in merge() and mergeSort():
     * <li>In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the merge().</li>
     * <li>While comparing a[left] and a[right] in the 3rd step of merge(), if a[left] > a[right], we will simply add this line:
     * cnt += mid-left+1 (mid+1 = size of the left half)</li>
     * <li>Now, we will return this cnt from merge() to mergeSort().</li>
     * <li>Inside mergeSort(), we will keep another counter variable that will store the final answer. With this cnt, we will add the answer returned from mergeSort() of the left half, mergeSort() of the right half, and merge().</li>
     * <li>Finally, we will return this cnt, as our answer from mergeSort().</li>
     * </ul>
     */
    private static int reversePairsOptimal(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{40, 25, 19, 12, 9, 6, 2};
        System.out.println("Reverse Pairs (Brute): " + reversePairsBruteForce(arr));
        System.out.println("Reverse Pairs (Optimal): " + reversePairsOptimal(arr));
    }
}
