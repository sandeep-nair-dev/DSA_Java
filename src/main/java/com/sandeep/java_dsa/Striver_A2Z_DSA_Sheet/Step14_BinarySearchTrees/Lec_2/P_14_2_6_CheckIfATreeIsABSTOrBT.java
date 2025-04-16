package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_6_CheckIfATreeIsABSTOrBT {

    public static boolean findBSTOrNot(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return findBSTOrNot(root.left, minValue, root.val) && findBSTOrNot(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{5, 4, 6, null, null, 3, 7};
        Node root = Node.createBinaryTree(arr);
        System.out.println("Given tree is a Binary Search Tree: " + findBSTOrNot(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}