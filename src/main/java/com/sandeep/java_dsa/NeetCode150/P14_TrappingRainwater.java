package com.sandeep.java_dsa.NeetCode150;

public class P14_TrappingRainwater {

    /**
     * Approach: for every i we check how much blocks can be filled with water.
     * Water filled at particular index = Min(max height to left of index, max height to right of index) - current index height
     * TC -> O(n)
     * SC -> O(n)
     */
    public static int trappedRainwaterGood(int[] arr){
        int trappedRainwater = 0;
        int[] leftMax = new int[arr.length];
        leftMax[0]=0;
        int[] rightMax = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            leftMax[i]=Math.max(leftMax[i-1], arr[i-1]);
        }
        rightMax[arr.length-1] = 0;
        for(int i=arr.length-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i + 1]);
        }

        for(int i=0;i<arr.length;i++){
            int current = (Math.min(leftMax[i], rightMax[i])) - arr[i];
            if(current>0) trappedRainwater+=current;
        }

        return trappedRainwater;
    }

    /**
     * Approach: Same approach, just not using arrays to store mins and calculating directly. We have 2 pointer left and right...and we keep track of maxLeft and maxRight<br>
     * in the formula also, we were taking min(lmax, rmax) which means we only need one, that is lesser
     * <ul>
     * <li>if(maxLeft < maxRight):<br>
     *      we move left index, update the left max and then add the (leftMax-current index height) to result
     *      </li>
     *  <li>else:<br>
     *      we move right index, update the right max and then add the (rightMax-current index height) to result</li>
     *      </ul>
     * TC -> O(n)
     * SC -> O(1)
     */
    public static int trappedRainwaterOptimal(int[] arr){
        int l=0, r=arr.length-1;
        int leftMax = arr[l];
        int rightMax = arr[r];
        int maxVol=0;
        while (l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                maxVol += leftMax-arr[l];
            }else{
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                maxVol += rightMax-arr[r];
            }
        }
        return maxVol;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,0,3,1,0,1,3,2,1};
        System.out.println("Trapped Rainwater (Good): " + trappedRainwaterGood(arr));
        System.out.println("Trapped Rainwater (Optimal): " + trappedRainwaterOptimal(arr));
    }
}
