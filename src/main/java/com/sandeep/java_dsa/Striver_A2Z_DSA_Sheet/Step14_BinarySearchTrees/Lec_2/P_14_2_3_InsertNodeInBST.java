package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import javax.swing.tree.TreeNode;

public class P_14_2_3_InsertNodeInBST {
    public static Node insertIntoBST(Node root, int val){
        if(root==null) return new Node(val);
        Node temp = root;
        while(temp!=null){
            if(temp.val<=val) {
                if(temp.right==null){
                    temp.right = new Node(val);
                    break;
                }
                else temp=temp.right;
            }
            else {
                if(temp.left==null){
                    temp.left = new Node(val);
                    break;
                }
                else temp=temp.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,7,1,3};
        int val=5;
        Node root  = Node.createBinaryTree(arr);
        root = insertIntoBST(root,5);

    }
}
