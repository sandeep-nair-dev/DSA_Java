package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class P53_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder_Iteration(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) continue;
                currLevel.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            if (!currLevel.isEmpty()) result.add(currLevel);
        }
        return result;
    }


    //Recursion

    private void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;

        if (res.size() == depth) res.add(new ArrayList<>());

        res.get(depth).add(root.val);
        dfs(root.left, res, depth + 1);
        dfs(root.right, res, depth + 1);
    }

    public List<List<Integer>> levelOrder_Recursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public static void main(String[] args) {

        // Test Case 1
        //          3
        //        /   \
        //       9     20
        //            /  \
        //           15   7

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // Test Case 2
        //          1
        //         /
        //        2

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        // Test Case 3: Empty tree
        TreeNode root3 = null;

        P53_BinaryTreeLevelOrderTraversal solution = new P53_BinaryTreeLevelOrderTraversal();

        System.out.println("Iteration Test Case 1: " + solution.levelOrder_Iteration(root1));
        System.out.println("Recursion Test Case 1: " + solution.levelOrder_Recursion(root1));
        // Expected: [[3], [9, 20], [15, 7]]

        System.out.println("Iteration Test Case 2: " + solution.levelOrder_Iteration(root2));
        System.out.println("Recursion Test Case 2: " + solution.levelOrder_Recursion(root2));
        // Expected: [[1], [2]]

        System.out.println("Iteration Test Case 3: " + solution.levelOrder_Iteration(root3));
        System.out.println("Recursion Test Case 3: " + solution.levelOrder_Recursion(root3));
        // Expected: []
    }
}
