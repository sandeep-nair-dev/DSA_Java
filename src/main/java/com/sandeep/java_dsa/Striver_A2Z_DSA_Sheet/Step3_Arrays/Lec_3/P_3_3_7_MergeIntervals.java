package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step3_Arrays.Lec_3;

import java.sql.Array;
import java.util.*;

public class P_3_3_7_MergeIntervals {

    /*
        Brute Force: Sort the array, for each i interval, check with every other interval if it can be merged
            TC -> O(N*logN) + O(2*N) {Sorting the given array takes  O(N*logN) time complexity.
            Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j.
            So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N^2.}
     */
    public static List<List<Integer>> bruteForce(int[][] arr) {
        int n = arr.length; // size of the array
        //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // select an interval:
            int start = arr[i][0];
            int end = arr[i][1];

            //Skip all the merged intervals:
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            //check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    /*
        Optimal Solution:
            TC-> O(N*logN) + O(N)
            SC -> O(N)  {For Storing the answer}
     */
    private static int[][] mergeIntervals(int[][] arr){
        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int[] element : arr) {
            if (result.isEmpty() || element[0] > result.getLast().get(1)) {
                result.add(Arrays.asList(element[0], element[1]));
            } else {
                result.getLast().set(1, Math.max(result.getLast().get(1), element[1]));
            }
        }
        int[][] finalResult = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            finalResult[i][0]=result.get(i).get(0);
            finalResult[i][1]=result.get(i).get(1);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged interals: " + Arrays.deepToString(mergeIntervals(arr)));
    }
}
