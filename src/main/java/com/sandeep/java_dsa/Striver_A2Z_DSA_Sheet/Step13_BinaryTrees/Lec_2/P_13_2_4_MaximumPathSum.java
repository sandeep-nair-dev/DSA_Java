package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_13_2_4_MaximumPathSum {

    private static int findMaxPathSum(Node root, int[] maxi){
        if(root==null) return 0;

        int leftPathSum = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightPathSum = Math.max(0, findMaxPathSum(root.right, maxi));
        maxi[0] = Math.max(maxi[0], leftPathSum+rightPathSum+root.val);
        return root.val+Math.max(leftPathSum, rightPathSum);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        int[] maxi = new int[1];
        maxi[0]=Integer.MIN_VALUE;
        findMaxPathSum(root, maxi);
        System.out.println("Maximum Path Sum of binary tree: " + maxi[0]);
    }
}