package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class P55_CountGoodNodesInBinaryTree {


    /*
        DFS
        TC -> O(n)
        SC -> O(n)
     */
    private int dfs(TreeNode node, int currMax) {
        if (node == null) return 0;

        int res = node.val >= currMax ? 1 : 0;
        int maxVal = Math.max(currMax, node.val);
        return res + dfs(node.left, maxVal) +
                dfs(node.right, maxVal);
    }

    public int goodNodes_DFS(TreeNode root) {
        return dfs(root, root.val);
    }

    /*
        BFS

     */

    class Pair<T,E>{
        T key;
        E value;

        public Pair(T key, E value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }
    public int goodNodes_BFS(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, root.val));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer maxVal = pair.getValue();
            if (node.val >= maxVal) res++;

            int newMax = Math.max(maxVal, node.val);
            if (node.left != null) queue.offer(new Pair<>(node.left, newMax));
            if (node.right != null) queue.offer(new Pair<>(node.right, newMax));
        }
        return res;
    }

    public static void main(String[] args) {

        // Test Case 1
        //          3
        //        /   \
        //       1     4
        //      /     / \
        //     3     1   5

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);

        // Test Case 2
        //          3
        //        /   \
        //       3     1
        //        \
        //         4

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(4);

        // Test Case 3: Single node
        TreeNode root3 = new TreeNode(1);

        // Test Case 4: Negative values
        //          -1
        //         /  \
        //        -2  -3

        TreeNode root4 = new TreeNode(-1);
        root4.left = new TreeNode(-2);
        root4.right = new TreeNode(-3);

        P55_CountGoodNodesInBinaryTree solution = new P55_CountGoodNodesInBinaryTree();

        System.out.println("Test Case 1: " + solution.goodNodes_DFS(root1));
        System.out.println("Test Case 1: " + solution.goodNodes_BFS(root1));
        // Expected: 4

        System.out.println("Test Case 2: " + solution.goodNodes_DFS(root2));
        System.out.println("Test Case 2: " + solution.goodNodes_BFS(root2));
        // Expected: 3

        System.out.println("Test Case 3: " + solution.goodNodes_DFS(root3));
        System.out.println("Test Case 3: " + solution.goodNodes_BFS(root3));
        // Expected: 1

        System.out.println("Test Case 4: " + solution.goodNodes_DFS(root4));
        System.out.println("Test Case 4: " + solution.goodNodes_BFS(root4));
        // Expected: 1
    }
}
