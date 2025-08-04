package com.sandeep.java_dsa.NeetCode150.Model;

import java.util.*;

public class Node {
    public int val;
    public Node left;
    public Node right;

    // Constructor to initialize
    // the node with a value
    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static Node createBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        // Create the root node
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element in the array
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Assign the left child
            if (arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign the right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
    public static void printTree(Node root) {
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

    private static int getHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static void fillLevels(Node node, int level, int left, int right, List<List<String>> levels, List<List<String>> links) {
        if (node == null) return;

        int mid = (left + right) / 2;
        levels.get(level).set(mid, Integer.toString(node.val));

        if (node.left != null) {
            int leftMid = (left + mid - 1) / 2;
            links.get(level).set(leftMid, "/");
            fillLevels(node.left, level + 1, left, mid - 1, levels, links);
        }
        if (node.right != null) {
            int rightMid = (mid + 1 + right) / 2;
            links.get(level).set(rightMid, "\\");
            fillLevels(node.right, level + 1, mid + 1, right, levels, links);
        }
    }
}
