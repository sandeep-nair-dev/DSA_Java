package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P56_ValidateBinarySearchTree {

    /*
        Brute Force -> Visit every node and for every node check if all values in left subtree is less than node and all values in right subtree are greater than node
        TC -> O(n^2)
        SC -> O(n)
     */

    /*
        DFS
        TC -> O(n)
        SC -> O(n)
     */
    private boolean dfs(TreeNode node, int rangeMin, int rangeMax) {
        if (node == null) return true;
        if (!(node.val > rangeMin && node.val < rangeMax)) {
            return false;
        }
        return dfs(node.left, rangeMin, node.val) && dfs(node.right, node.val, rangeMax);
    }

    public boolean isValidBST_DFS(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /*
        BFS

     */
    public boolean isValidBST_BFS(TreeNode root) {
        if(root==null) return true;

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});
        while (!queue.isEmpty()){
            Object[] poll = queue.poll();
            TreeNode node = (TreeNode) poll[0];
            int min = (int) poll[1];
            int  max = (int) poll[2];

            if(!(node.val>min && node.val<max)){
                return false;
            }

            if(node.left!=null) queue.offer(new Object[]{node.left, min, node.val});
            if(node.right!=null) queue.offer(new Object[]{node.right, node.val, max});
        }
        return true;
    }

    public static void main(String[] args) {

        // Test Case 1: Valid BST
        //          2
        //        /   \
        //       1     3

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // Test Case 2: Invalid BST
        //          5
        //        /   \
        //       1     4
        //            / \
        //           3   6

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        // Test Case 3: Invalid BST (Violation across subtrees)
        //          5
        //        /   \
        //       1     7
        //            /
        //           4

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(7);
        root3.right.left = new TreeNode(4);

        // Test Case 4: Single node
        TreeNode root4 = new TreeNode(1);

        // Test Case 5: Empty tree
        TreeNode root5 = null;

        // Test Case 6: Duplicate values (Invalid BST)
        TreeNode root6 = new TreeNode(2);
        root6.left = new TreeNode(2);

        P56_ValidateBinarySearchTree solution = new P56_ValidateBinarySearchTree();

        System.out.println("Test Case 1 Expected: " + true);
        System.out.println("Test Case 1: " + solution.isValidBST_DFS(root1));
        System.out.println("Test Case 1: " + solution.isValidBST_BFS(root1));
        // Expected: true
        System.out.println("---");
        System.out.println("Test Case 2 Expected: " + false);
        System.out.println("Test Case 2: " + solution.isValidBST_DFS(root2));
        System.out.println("Test Case 2: " + solution.isValidBST_BFS(root2));
        // Expected: false

        System.out.println("---");
        System.out.println("Test Case 3 Expected: " + false);
        System.out.println("Test Case 3: " + solution.isValidBST_DFS(root3));
        System.out.println("Test Case 3: " + solution.isValidBST_BFS(root3));
        // Expected: false

        System.out.println("---");
        System.out.println("Test Case 4 Expected: " + true);
        System.out.println("Test Case 4: " + solution.isValidBST_DFS(root4));
        System.out.println("Test Case 4: " + solution.isValidBST_BFS(root4));
        // Expected: true

        System.out.println("---");
        System.out.println("Test Case 5 Expected: " + true);
        System.out.println("Test Case 5: " + solution.isValidBST_DFS(root5));
        System.out.println("Test Case 5: " + solution.isValidBST_BFS(root5));
        // Expected: true

        System.out.println("---");
        System.out.println("Test Case 6 Expected: " + false);
        System.out.println("Test Case 6: " + solution.isValidBST_DFS(root6));
        System.out.println("Test Case 6: " + solution.isValidBST_BFS(root6));
        // Expected: false
    }
}
