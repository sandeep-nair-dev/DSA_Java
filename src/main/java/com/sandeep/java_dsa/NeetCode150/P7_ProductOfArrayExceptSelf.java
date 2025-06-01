package com.sandeep.java_dsa.NeetCode150;

import java.util.Arrays;

/**
 * <h3><b>Problem Statement</b></h3>
 * <p>Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].<br>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.<br>
 * You must write an algorithm that runs in O(n) time and without using the division operation.<br><br>
 *
 * Example 1:<br>
 *
 * Input: nums = [1,2,3,4]<br>
 * Output: [24,12,8,6]<br><br>
 * Example 2:<br>
 *
 * Input: nums = [-1,1,0,-3,3]<br>
 * Output: [0,0,9,0,0]<br>
 * </p>
 */
public class P7_ProductOfArrayExceptSelf {

    public static int[] solutionNaive(int[] arr){
        int[] result= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int product=1;
            for(int j=0;j<arr.length;j++){
                if(j!=i) product*=arr[j];
            }
            result[i]=product;
        }
        return result;
    }


    /**
     * <b>Approach: </b><p>Calculate product of all numbers and then divide the total product by that number</p>
        TC-> O(n)               <br>
        SC -> O(1)              <br>
     */
    public static int[] optimalSolution_UsingDivision(int[] arr){
        int[] result = new int[arr.length];
        int product = 1;
        int zeroCount=0;
        for (int i : arr) {
            if(i!=0) {
                product *= i;
            }else{
                zeroCount++;
            }
        }
        if(zeroCount>1) return result;                  // if one zero then will be a case where that one zero is not included in the product, but if there are more than one zero, all will be zero
        for(int i=0;i<arr.length;i++){
            if(zeroCount>0){
                result[i]=(arr[i]==0)?product:0;        // means currently we are excluding the only zero in the array, so the product should be the total product we got, because in other cases since zero might be included product will be zero
            }else {
                result[i] = product / arr[i];
            }
        }
        return result;
    }

    /**
     *<b>Approach: </b><p>To get product of all numbers except self, get product of all numbers before current and get product of all numbers after current and multiply them with each other</p>
     * TC-> O(n) <br>
     * SC -> O(2n) == O(n) <br>
     */
    public static int[] betterSolution_UsingPrefixPostFix(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        prefix[0]=1;
        suffix[n-1]=1;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]*arr[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]*arr[i+1];
        }
        for(int i=0;i<n;i++){
            res[i] = prefix[i]*suffix[i];
        }
        return res;
    }

/**
 *<b>Approach: </b><p>Same are previous approach, multiplication of prefix and suffix...just that here instead of using 2 arrays, we are using the result array itself</p>
 * TC -> O(n)
 * SC -> O(1)
 */
    public static int[] optimalSolution_UsingPrefixPostFix(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i] = res[i-1]*arr[i-1];
        }
        int postfix=1;
        for(int i=n-1;i>=0;i--){
            res[i]*=postfix;
            postfix*=arr[i];
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6};
        System.out.println("Product of Array Elements Except Self (Naive): " + Arrays.toString(solutionNaive(nums)));
        System.out.println("Product of Array Elements Except Self (2): " + Arrays.toString(optimalSolution_UsingDivision(nums)));
        System.out.println("Product of Array Elements Except Self (3): " + Arrays.toString(betterSolution_UsingPrefixPostFix(nums)));
        System.out.println("Product of Array Elements Except Self (4): " + Arrays.toString(optimalSolution_UsingPrefixPostFix(nums)));
    }
}
