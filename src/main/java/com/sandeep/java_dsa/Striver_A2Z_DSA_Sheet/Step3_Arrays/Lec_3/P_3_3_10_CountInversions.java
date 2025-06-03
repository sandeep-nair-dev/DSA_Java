package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.ArrayList;

/**
 * <h3><b>Problem Statement</b></h3>
 * <p>Given an array of N integers, count the inversion of the array (using merge-sort).<br>
 * What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].</p>
 */
public class P_3_3_10_CountInversions {

    private static int inversionsBrute(int[] arr){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]) count++;
            }
        }
        return count;
    }

    private static int merge(int[] arr, int lo, int mid, int hi){
        ArrayList<Integer> temp = new ArrayList<>();
        int count=0;
        int left=lo, right=mid+1;
        while (left<=mid && right<=hi){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
                count+=mid-left+1;
            }
        }
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while (right<=hi){
            temp.add(arr[right]);
            right++;
        }

        for(int i=lo;i<=hi;i++){
            arr[i]=temp.get(i-lo);
        }
        return count;
    }

    private static int mergeSort(int[] arr, int lo, int hi){
        int count=0;
        if(lo>=hi) return count;
        int mid = (lo+hi)/2;
        count+=mergeSort(arr, lo, mid);
        count+=mergeSort(arr, mid+1, hi);
        count+=merge(arr, lo, mid, hi);
        return count;
    }

    /**
        <b>Optimal Solution</b> <br>
        TC -> O(N*logN)     <br>
        SC -> O(N) {for temp array}     <br>
     <br>
        Here we are sorting too so end up distorting the array, if we want to not distort the array, we'd have to take a copy of the array and perform on that.<br><br>

        <b>Approach:</b>

     The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just in the mergeSort() function:
     <ul>
     <li>In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the mergeSort().</li>
     <li>We will add the numbers returned by the previous mergeSort() calls.</li>
     <li>Before the merge step, we will count the number of pairs using a function, named countPairs().</li>
     <li>We need to remember that the left half starts from low and ends at mid, and the right half starts from mid+1 and ends at high.</li><br>
     The steps of the countPairs() function will be as follows:

     <li>We will declare a variable, cnt, initialized with 0.</li>
     <li>We will run a loop from low to mid, to select an element at a time from the left half.</li>
     <li>Inside that loop, we will use another loop to check how many elements from the right half can make a pair.</li>
     <li>Lastly, we will add the total number of elements i.e. (right-(mid+1)) (where right = current index), to the cnt and return it.</li>
     </ul>



     <b> my exp:</b>
     <p>Doing the same as mergeSort, but before merging the two sorted arrays, we count the pairs satisfying the condition. We cant do like we did in count inversions because at i=1 the condition may be false but for i=2 the condition might be true but according to previous logic, we lose out on these.
     That's why we are doing reverse, instead of checking for every right, how much left satisfies, we are checking for each left, how much elements in right are satisfying, because if for i=3 the condition arr[i]>2*arr[j] is true...for i=4 also it would be true because array is sorted.</p>

     */
    private static int countInversionsOptimal(int[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        System.out.println("Inversions (Brute): " + inversionsBrute(arr));
        System.out.println("Inversions (Optimal): " + countInversionsOptimal(arr));
    }
}
