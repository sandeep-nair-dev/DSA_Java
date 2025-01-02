package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step4_BinarySearch.Lec_3;

public class P4_3_2_SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lo=0, hi=(n*m)-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int midRow=mid/m; //for row, divide by total number of columns
            int midCol=mid%m;  //for col, get the remainder on dividing by number of columns
            int element = matrix[midRow][midCol];
            if(element==target){
                return true;
            }else if(element<target){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return false;
    }

}
