package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P54_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

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

        System.out.println("Test Case 1: " + solution.rightSideView(root1));
        // Expected: [1, 3, 4]

        System.out.println("Test Case 2: " + solution.rightSideView(root2));
        // Expected: [1, 2, 3]

        System.out.println("Test Case 3: " + solution.rightSideView(root3));
        // Expected: []

        System.out.println("Test Case 4: " + solution.rightSideView(root4));
        // Expected: [1]
    }
}
