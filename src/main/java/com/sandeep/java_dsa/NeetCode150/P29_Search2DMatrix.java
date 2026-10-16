package com.sandeep.java_dsa.NeetCode150;

public class P29_Search2DMatrix {

    /*
    Two pass - First we identify the row that could have the element using binary search, then apply binary search in that row to find the element;
     */

    public boolean searchMatrix2(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /*
    Optimal - One Pass
     */
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0, hi = (m * n) - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        System.out.println(searchMatrix(arr, 10));
    }
}
