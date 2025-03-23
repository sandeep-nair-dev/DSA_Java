package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_1;

public class P_14_1_1_IsInorderTraversalOfBST {
    private static boolean isBSTTraversal(int arr[]) {
        // code here
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]<=arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 14, 45, 64, 100};
        System.out.println("Is inorder traversal given of a BST: " + isBSTTraversal(arr));
    }
}
