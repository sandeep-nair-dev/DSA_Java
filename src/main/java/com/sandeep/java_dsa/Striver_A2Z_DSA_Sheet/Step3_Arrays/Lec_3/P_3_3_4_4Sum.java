package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_3_3_4_4Sum {

    /*
        Brute Force: Usign 4 loops
        TC -> O(N^4)
        SC -> O(2*No. Of unique quadruplets)
     */

    /*
        Better Approach: 3 loops and Hashset for 4th element, like in previous problem
        TC -> O(N^3 * logM) {logM is finding element in hashset and it is M and not N because size of set varies and is not N everytime}
        SC -> O(logN) {Hashset} + 2*O(No. of unique quadruplets) {Storing the answer List<List<>> and Set<List<>>}
     */

    /*
        Optimal Approach: 2 loops and two pointer for rest 2 values
        TC -> O(N*logN) {Sorting} + O(N^3)
        SC -> O(No. of unique quadruplets)
     */

    private static List<List<Integer>> optimalWay(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    long sum = (long)arr[i] + (long)arr[j] + (long)arr[k] + (long)arr[l];
                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[k - 1] == arr[k]) k++;
                        while (k < l && arr[l + 1] == arr[l]) l--;
                    } else if (sum < target) k++;
                    else l--;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println("Optimal Way: " + optimalWay(arr, target));
    }
}
