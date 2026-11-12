package com.sandeep.java_dsa.Algorithms;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    /**
     * Morris Traversal
     * In this we do the traversal using constant space i.e. without using call stack or explicit datastructure. This is achieved using threaded binary tree.
     * In normal traversal, we rely on backtracking and stack to go back, but in this, we will be creating a link between the leaf node and the root of a subtree so that we can go back to the node
     *
     * For each node:
     * - If it has no left child node, visit it directly
     * - If it has a left child - find its inorder predecessor
     *      - If the predecessor's right pointer is empty - create a temporary link to the current node and move left
     *      - If the predecessor's right pointer already points to the current node - remove the link, visit the node, and move right.
     *
     * TC -> O(N)
     * SC -> O(1)
     */

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Test Case 1: Complete Binary Tree
        //          4
        //        /   \
        //       2     6
        //      / \   / \
        //     1   3 5   7

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);

        // Test Case 2: Left-skewed Binary Tree
        //          5
        //         /
        //        4
        //       /
        //      3
        //     /
        //    2

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(2);

        // Test Case 3: Right-skewed Binary Tree
        //     1
        //      \
        //       2
        //        \
        //         3
        //          \
        //           4

        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);

        // Test Case 4: Empty Binary Tree
        TreeNode root4 = null;

        // Test Case 5: Single Node
        TreeNode root5 = new TreeNode(10);

        MorrisTraversal solution = new MorrisTraversal();

        // Test Case 1
        System.out.println("========== Test Case 1 ==========");

        System.out.println("Inorder Expected:  [1, 2, 3, 4, 5, 6, 7]");
        System.out.println("Inorder Actual:    " + solution.inorderTraversal(root1));

        System.out.println("Preorder Expected: [4, 2, 1, 3, 6, 5, 7]");
        System.out.println("Preorder Actual:   " + solution.preorderTraversal(root1));


        // Test Case 2
        System.out.println("\n========== Test Case 2 ==========");

        System.out.println("Inorder Expected:  [2, 3, 4, 5]");
        System.out.println("Inorder Actual:    " + solution.inorderTraversal(root2));

        System.out.println("Preorder Expected: [5, 4, 3, 2]");
        System.out.println("Preorder Actual:   " + solution.preorderTraversal(root2));


        // Test Case 3
        System.out.println("\n========== Test Case 3 ==========");

        System.out.println("Inorder Expected:  [1, 2, 3, 4]");
        System.out.println("Inorder Actual:    " + solution.inorderTraversal(root3));

        System.out.println("Preorder Expected: [1, 2, 3, 4]");
        System.out.println("Preorder Actual:   " + solution.preorderTraversal(root3));


        // Test Case 4
        System.out.println("\n========== Test Case 4 ==========");

        System.out.println("Inorder Expected:  []");
        System.out.println("Inorder Actual:    " + solution.inorderTraversal(root4));

        System.out.println("Preorder Expected: []");
        System.out.println("Preorder Actual:   " + solution.preorderTraversal(root4));


        // Test Case 5
        System.out.println("\n========== Test Case 5 ==========");

        System.out.println("Inorder Expected:  [10]");
        System.out.println("Inorder Actual:    " + solution.inorderTraversal(root5));

        System.out.println("Preorder Expected: [10]");
        System.out.println("Preorder Actual:   " + solution.preorderTraversal(root5));
    }


}
