package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_13_2_2_CheckIfTheBinaryTreeIsHeight_BalancedOrNot {

    /*
    naive soln: two methods...one to find height and another to check if Math.abs(lh-rh)>1.....starting from root node in check method, find height of subtrees of every node and check diff, if not balanced till here return false, otherwise check for subtrees too
    T.C. -> O(n^2) {check node and for checking we are calculation subtree height for every node}
    S.C -> O(n) {n= no of nodes...recursive stack space}
     */

    /*
        T.C. -> O(n)
        S.C. -> O(n) {Recursive stack space}
     */
    private static int findIfBalanced(Node root){
        if(root==null) return 0;
        int leftHeight = findIfBalanced(root.left);
        int rightHeight = findIfBalanced(root.right);

        if(leftHeight==-1 || rightHeight==-1) return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        boolean ans = findIfBalanced(root) >= 0;
        System.out.println("Is tree balanced? : " + ans);
    }
}