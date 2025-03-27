package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_1_3_MinMaxElementInBST {
    public static int minValue(Node root) {
        // code here
        int max=0;
        while(root!=null){
            max=root.val;
            root=root.left;
        }
        return max;
    }

    public static int maxValue(Node root) {
        // code here
        int max=0;
        while(root!=null){
            max=root.val;
            root=root.right;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,7,1,3};
        Node root = Node.createBinaryTree(arr);
        System.out.println("Min Value: " + minValue(root));
        System.out.println("Max Value: " + maxValue(root));
    }
}
