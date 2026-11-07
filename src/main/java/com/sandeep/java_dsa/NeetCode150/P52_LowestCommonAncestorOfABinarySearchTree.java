package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

public class P52_LowestCommonAncestorOfABinarySearchTree {


    public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;

        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor_recursion(root.left, p,q);
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor_recursion(root.right, p,q);
        else return root;
    }

    public TreeNode lowestCommonAncestor_Iteration(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=root;
        while (curr!=null){
            if(p.val<root.val && q.val<root.val) curr=curr.left;
            else if (p.val>root.val && q.val>root.val) curr=curr.right;
            else return curr;
        }
        return null;
    }


        public static void main(String[] args) {

        // Construct BST
        //          6
        //        /   \
        //       2     8
        //      / \   / \
        //     0   4 7   9
        //        / \
        //       3   5

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        P52_LowestCommonAncestorOfABinarySearchTree solution = new P52_LowestCommonAncestorOfABinarySearchTree();

        // Test Case 1: LCA of 2 and 8
        TreeNode p1 = root.left;
        TreeNode q1 = root.right;

        TreeNode result1 = solution.lowestCommonAncestor_Iteration(root, p1, q1);
        System.out.println("LCA of 2 and 8: " + result1.val);
        // Expected: 6

        // Test Case 2: LCA of 2 and 4
        TreeNode p2 = root.left;
        TreeNode q2 = root.left.right;

        TreeNode result2 = solution.lowestCommonAncestor_Iteration(root, p2, q2);
        System.out.println("LCA of 2 and 4: " + result2.val);
        // Expected: 2

        // Test Case 3: LCA of 3 and 5
        TreeNode p3 = root.left.right.left;
        TreeNode q3 = root.left.right.right;

        TreeNode result3 = solution.lowestCommonAncestor_Iteration(root, p3, q3);
        System.out.println("LCA of 3 and 5: " + result3.val);
        // Expected: 4
    }
}
