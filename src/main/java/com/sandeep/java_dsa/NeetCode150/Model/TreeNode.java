package com.sandeep.java_dsa.NeetCode150.Model;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // Constructor to initialize
    // the node with a value
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static TreeNode createBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        // Create the root node
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element in the array
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Assign the left child
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign the right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static void printTree(TreeNode root) {
        if (root == null) return;

        int height = getHeight(root);
        int maxWidth = (int) Math.pow(2, height) - 1; // Maximum width of tree representation
        List<List<String>> levels = new ArrayList<>();
        List<List<String>> links = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            levels.add(new ArrayList<>(Collections.nCopies(maxWidth, " ")));
            if (i < height - 1) {
                links.add(new ArrayList<>(Collections.nCopies(maxWidth, " ")));
            }
        }

        fillLevels(root, 0, 0, maxWidth - 1, levels, links);

        // Print tree with connecting lines
        for (int i = 0; i < levels.size(); i++) {
            for (String s : levels.get(i)) {
                System.out.print(s);
            }
            System.out.println();
            if (i < links.size()) {
                for (String s : links.get(i)) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static void fillLevels(TreeNode treeNode, int level, int left, int right, List<List<String>> levels, List<List<String>> links) {
        if (treeNode == null) return;

        int mid = (left + right) / 2;
        levels.get(level).set(mid, Integer.toString(treeNode.val));

        if (treeNode.left != null) {
            int leftMid = (left + mid - 1) / 2;
            links.get(level).set(leftMid, "/");
            fillLevels(treeNode.left, level + 1, left, mid - 1, levels, links);
        }
        if (treeNode.right != null) {
            int rightMid = (mid + 1 + right) / 2;
            links.get(level).set(rightMid, "\\");
            fillLevels(treeNode.right, level + 1, mid + 1, right, levels, links);
        }
    }
}
