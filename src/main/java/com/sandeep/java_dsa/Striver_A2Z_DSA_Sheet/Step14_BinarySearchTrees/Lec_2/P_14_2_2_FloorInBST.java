package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_2_FloorInBST {
    public static int floor(Node root, int x) {
        // Code here
        int floor=-1;
        while(root!=null){
            if(root.val==x) return root.val;
            if(root.val<x){
                floor=root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 1, 7, null, 2, null, null, null, 3};
        int key = 3;
        Node root = Node.createBinaryTree(arr);
        System.out.println("Ceil: " + floor(root, 3));
    }
}
