package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.Node;

public class P48_DiameterOfBinaryTree {

    private static int findHeight(Node root, int[] diameter){
        if(root==null) return 0;

        int leftHeight = findHeight(root.left, diameter);
        int rightHeight = findHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }

    private static int findDiameter(Node root){
        int[] diameter = new int[1];
        findHeight(root, diameter);
        return diameter[0];
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Node binaryTree = Node.createBinaryTree(arr);
        Node.printTree(binaryTree);
        System.out.println(findDiameter(binaryTree));
    }
}
