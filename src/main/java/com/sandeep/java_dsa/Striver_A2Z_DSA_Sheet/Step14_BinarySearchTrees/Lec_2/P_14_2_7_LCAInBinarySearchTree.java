package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_7_LCAInBinarySearchTree {

    /*
        Recursion:
            TC -> O(H) =-> H: Height of the tree
            SC -> O(1) + O(H){Recursive Stack Space)
     */
    private static Node findLCARecursion(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) {
            return findLCARecursion(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return findLCARecursion(root.left, p, q);
        }
        return root;
    }

    /*
        Recursion:
            TC -> O(H) =-> H: Height of the tree
            SC -> O(1)
     */
    public static Node findLCAIterative(Node root, Node p, Node q){
        if(root==null) return null;
        while(root!=null){
            if(root.val<p.val && root.val<q.val){
                root=root.right;
            }
            else if(root.val>p.val && root.val>q.val){
                root=root.left;
            }
            else break;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        Node root = Node.createBinaryTree(arr);
        Node p = new Node(2);
        Node q = new Node(8);
        System.out.println("Lowest Common Ancestor: " + findLCARecursion(root, p, q).val);
        System.out.println("Lowest Common Ancestor: " + findLCAIterative(root, p, q).val);
    }
}