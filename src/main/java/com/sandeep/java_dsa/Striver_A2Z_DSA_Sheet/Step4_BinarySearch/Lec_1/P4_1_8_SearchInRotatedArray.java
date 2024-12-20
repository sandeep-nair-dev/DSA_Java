package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_1;

public class P4_1_8_SearchInRotatedArray {
        public static int search(int[] nums, int target) {
            int n = nums.length;
            int low=0, high=n-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid]==target) return mid;
                else{
                    if(nums[low]<=nums[mid]){
                        if(nums[low]<=target && nums[mid]>=target){
                            high=mid-1;
                        }else{
                            low=mid+1;
                        }
                    }else{
                        if(nums[mid]<=target && nums[high]>=target){
                            low=mid+1;
                        }else{
                            high=mid-1;
                        }
                    }
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        int k = 1;
        int ans = search(arr, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}
