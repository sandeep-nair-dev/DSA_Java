package com.sandeep.java_dsa.Algorithms;

public class MooresVotingAlgorithm {
    public static int mooresVotingAlgorithm(int[] nums){
        int n = nums.length;
        int element = nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]==element){
                count++;
            }else{
                count--;
            }
            if(count<0){
                element=nums[i];
                count=0;
            }
        }
        return element;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};
        int duplicate = mooresVotingAlgorithm(arr);
        System.out.println(duplicate);
    }
}
