package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.util.*;

public class P_3_3_3_3Sum {
    /*
        Brute Force
            TC -> O(n^3 * log(no. of unique triplets))
            SC -> 2*O(no. of triplets)  {Stored for answer}
     */
    private static List<List<Integer>> bruteForce(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(Comparator.naturalOrder());
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    /*
        Better Way -> Using Hashset
        TC -> O(N^2 * logM) {logM is finding element in hashset and it is M and not N because size of set varies and is not N everytime}
        SC -> O(N) {Hashset} + 2*O(No. of unique triplets) {Storing the answer List<List<>> and Set<List<>>}
     */
    private static List<List<Integer>> betterWay(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int target = -(arr[i] + arr[j]);
                if (hashset.contains(target)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], target);
                    temp.sort(Comparator.naturalOrder());
                    set.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

    /*
        Optimal Way -> Using 2-pointer
        TC -> O(N * logN) {Sorting} + O(N^2) {i goes 0 to n and for each i we traverse nearabout n times, so near to n^2)
        SC -> O(no. of unique triplets) {List<List<>> to store the answer}
     */
    private static List<List<Integer>> optimalWay(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Brute Force Method: " + bruteForce(arr));
        System.out.println("Better Method: " + betterWay(arr));
        System.out.println("Optimal Method: " + optimalWay(arr));
    }
}
