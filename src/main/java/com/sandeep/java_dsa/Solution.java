package com.sandeep.java_dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        // Write your code here
//        List<Integer> ans = new ArrayList<>();
//        int i=0, j=0;
//        while(i<a.length && j<b.length){
//            if(a[i]<b[j]){
//                ans.add(a[i]);
//                i++;
//            }
//            else if(b[j]<a[i]){
//                ans.add(b[j]);
//                j++;
//            }else{
//                ans.add(a[i]);
//                i++;
//                j++;
//            }
//        }
//        while(i<a.length){
//            ans.add(a[i]);
//            i++;
//        }
//        while( j<b.length){
//            ans.add(b[j]);
//            j++;
//        }
//        return ans;

        HashSet<Integer> hash = new HashSet<>();
        for (Integer i : a) {
            hash.add(i);
        }
        for (Integer i : b) {
            hash.add(i);
        }
        List<Integer> ans = new ArrayList<>(hash);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 6};
        int[] b = new int[]{2, 3, 5};
        System.out.println(sortedArray(a, b));
    }
}