package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P54_BinaryTreeRightSideView {

    /*
        Iteration
        TC -> O(n)
        SC -> O(n)
    */
    public List<Integer> rightSideView_Iteration1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = null;
            for (int i = 0; i < queue.size(); i++) {
                node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            result.add(node.val);
        }
        return result;
    }

    /*
        Iteration
        TC -> O(n)
        SC -> O(n)
    */
    public List<Integer> rightSideView_Iteration2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode rightNode = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    rightNode = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (rightNode != null) result.add(rightNode.val);
        }
        return result;
    }

    /*
        Recursion
        TC -> O(n)
        SC -> O(n)
    */
    public void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null) return;

        if (result.size() == depth) {
            result.add(node.val);
        }
        dfs(node.right, result, depth + 1);
        dfs(node.left, result, depth + 1);
    }

    public List<Integer> rightSideView_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    public static void main(String[] args) {

        // Test Case 1
        //          1
        //        /   \
        //       2     3
        //        \     \
        //         5     4

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        // Test Case 2
        //          1
        //         /
        //        2
        //         \
        //          3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(3);

        // Test Case 3: Empty tree
        TreeNode root3 = null;

        // Test Case 4: Single node
        TreeNode root4 = new TreeNode(1);

        P54_BinaryTreeRightSideView solution = new P54_BinaryTreeRightSideView();

        System.out.println("Test Case 1: " + solution.rightSideView_Iteration1(root1));
        System.out.println("Test Case 1: " + solution.rightSideView_Iteration2(root1));
        System.out.println("Test Case 1: " + solution.rightSideView_recursion(root1));
        // Expected: [1, 3, 4]

        System.out.println("Test Case 2: " + solution.rightSideView_Iteration1(root2));
        System.out.println("Test Case 2: " + solution.rightSideView_Iteration2(root2));
        System.out.println("Test Case 2: " + solution.rightSideView_recursion(root2));
        // Expected: [1, 2, 3]

        System.out.println("Test Case 3: " + solution.rightSideView_Iteration1(root3));
        System.out.println("Test Case 3: " + solution.rightSideView_Iteration2(root3));
        System.out.println("Test Case 3: " + solution.rightSideView_recursion(root3));
        // Expected: []

        System.out.println("Test Case 4: " + solution.rightSideView_Iteration1(root4));
        System.out.println("Test Case 4: " + solution.rightSideView_Iteration2(root4));
        System.out.println("Test Case 4: " + solution.rightSideView_recursion(root4));
        // Expected: [1]
    }
}
