package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.Node;

public class P49_BalancedBinaryTree {

    private static int checkBinaryTreeBalanced(Node root, boolean[] balanced){
        if(root==null || !balanced[0]) return 0;

        int leftHeight = checkBinaryTreeBalanced(root.left, balanced);
        int rightHeight = checkBinaryTreeBalanced(root.right, balanced);

        if(Math.abs(leftHeight - rightHeight) > 1) balanced[0]=false;
        return 1+Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        Node root = Node.createBinaryTree(arr);
        Node.printTree(root);

        boolean[] balanced = new boolean[1];
        balanced[0]=true;
        checkBinaryTreeBalanced(root,balanced);
        System.out.println(balanced[0]);
    }
}
