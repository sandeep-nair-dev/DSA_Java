package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import javax.swing.tree.TreeNode;

public class P_14_1_2_SearchInBST {

    public static Node searchBST(Node root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,7,1,3};
        int val=2;
        Node root = Node.createBinaryTree(arr);
        Node res = searchBST(root, val);
        System.out.println(res);
    }
}
