package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.Node;

public class P47_MaxDepthOfBinaryTree {

    private static int findMaximumDepth(Node root){
        if(root==null) return 0;
        return 1+Math.max(findMaximumDepth(root.left), findMaximumDepth(root.right));
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        Node binaryTree = Node.createBinaryTree(arr);
        System.out.println(findMaximumDepth(binaryTree));
    }
}
