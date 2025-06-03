package com.sandeep.java_dsa.NeetCode150;

public class P13_ContainerWithMostWater {

    /**
     * TC -> O(n)
     * SC -> O(1)
     */
    public static int maxWaterStoredOptimal(int[] arr) {
        int i = 0, j = arr.length - 1;
        int maxVol = 0;
        while (i < j) {
            maxVol = Math.max(maxVol, ((j - i) * (Math.min(arr[i], arr[j]))));
            if (arr[i] < arr[j]) i++;
            else j--;
        }
        return maxVol;
    }

    public static int maxWaterStoredNaive(int[] arr) {
        int maxVol = 0;
        for(int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                maxVol = Math.max(maxVol, ((j - i) * (Math.min(arr[i], arr[j]))));
            }
        }
        return maxVol;
    }
        public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 2, 5, 4, 7, 3, 6};
        System.out.println("Max vol. of water that can be stored (Naive) : " + maxWaterStoredNaive(arr));
        System.out.println("Max vol. of water that can be stored (2) : " + maxWaterStoredOptimal(arr));
    }
}
