package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_13_2_7_BoundaryTraversalOfBinaryTree {

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private static void addLeftBoundary(Node root, List<Integer> boundary) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) boundary.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private static void addLeafNodes(Node node, List<Integer> boundary) {
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }

        if (node.left != null) addLeafNodes(node.left, boundary);
        if (node.right != null) addLeafNodes(node.right, boundary);
    }

    private static void addRightBoundary(Node root, List<Integer> boundary) {
        Node curr = root.right;
        Stack<Integer> rightBoundary = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) rightBoundary.add(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while (!rightBoundary.isEmpty()) {
            boundary.add(rightBoundary.pop());
        }
    }

    private static List<Integer> traverseBoundary(Node root) {
        List<Integer> boundary = new ArrayList<>();
        if (!isLeaf(root)) boundary.add(root.val);
        addLeftBoundary(root, boundary);
        addLeafNodes(root, boundary);
        addRightBoundary(root, boundary);
        return boundary;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        List<Integer> boundary = traverseBoundary(root);
        System.out.println("Boundary: " + boundary);
    }
}