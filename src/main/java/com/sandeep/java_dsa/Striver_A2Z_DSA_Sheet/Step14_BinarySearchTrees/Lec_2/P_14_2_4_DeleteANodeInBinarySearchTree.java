package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_4_DeleteANodeInBinarySearchTree {

    private static Node helper(Node root){
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        else{
            Node rightChild = root.right;
            Node rightMostChildOfLeftBST = findRightmostChild(root.left);
            rightMostChildOfLeftBST.right=rightChild;
            return root.left;
        }
    }

    private static Node findRightmostChild(Node root){
        if(root.right==null) return root;
        return findRightmostChild(root.right);
    }

    public static Node deleteNode(Node root, int key){
        if(root==null) return null;
        if(root.val==key) return helper(root);
        Node temp = root;
        while (temp!=null){
            if(key<temp.val) {
                if (temp.left != null && temp.left.val == key) {
                    temp.left = helper(temp.left);
                }else{
                    temp=temp.left;
                }
            }else{
                if(temp.right!=null && temp.right.val==key){
                    temp.right=helper(temp.right);
                }else{
                    temp=temp.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,3,6,2,4,null,7};
        int key=3;
        Node root = Node.createBinaryTree(arr);
        Node.printTree(root);
        Node result = deleteNode(root, key);
        System.out.println("----------------------------");
        Node.printTree(result);
    }
}