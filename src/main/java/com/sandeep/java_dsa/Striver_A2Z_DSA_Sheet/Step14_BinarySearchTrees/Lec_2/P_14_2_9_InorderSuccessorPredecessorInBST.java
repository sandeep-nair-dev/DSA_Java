package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_9_InorderSuccessorPredecessorInBST {

    /*
        Brute Force: Store the inorder traversal of the BST, do binary search on it to find key and return element before and after that
        TC -> O(N) + O(logN)
        SC -> O(N)
     */

    /*
        Better approach to find successor: return the first element greater than key while doing inorder traversal...or first element smaller than 8 while doing reverse inorder
        TC -> O(N)
        SC -> O(1)
     */


    private static int findInorderSuccessor(Node root, int key){
        int successor = -1;
        while (root!=null){
            if(root.val>key) {
                successor=root.val;
                root=root.left;
            }else {
                root=root.right;
            }
        }
        return successor;
    }

    private static int findInorderPredecessor(Node root, int key){
        int predecessor=-1;
        while (root!=null){
            if(root.val<key){
                predecessor = root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 2, 11, 1, 5, null, null, null, null, 3, 6, null, 4, null, null};
        int key=8;
        Node root = Node.createBinaryTree(arr);
        System.out.println("Predecessor: " + findInorderPredecessor(root, key) + "\nSuccessor: " + findInorderSuccessor(root, key));
    }
}