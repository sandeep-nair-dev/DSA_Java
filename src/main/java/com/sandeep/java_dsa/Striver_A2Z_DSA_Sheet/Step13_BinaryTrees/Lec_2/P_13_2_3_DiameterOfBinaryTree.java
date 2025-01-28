package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_13_2_3_DiameterOfBinaryTree {

    private static int findDiameter(Node root, int[] diameter){
        if(root==null) return 0;

        int lh=findDiameter(root.left, diameter);
        int rh=findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1+Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        System.out.println("Diameter of binary tree: " + diameter[0]);
    }
}