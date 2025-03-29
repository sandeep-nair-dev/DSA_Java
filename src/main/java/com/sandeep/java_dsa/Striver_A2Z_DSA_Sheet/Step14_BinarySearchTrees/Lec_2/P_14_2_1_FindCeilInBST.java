package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_1_FindCeilInBST {
    private static int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int ceil = -1;
        while(root!=null){
            if(root.val==key) return root.val;
            if(root.val>key){
                ceil = root.val;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 1, 7, null, 2, null, null, null, 3};
        int key = 3;
        Node root = Node.createBinaryTree(arr);
        System.out.println("Ceil: " + findCeil(root, 3));
    }
}
