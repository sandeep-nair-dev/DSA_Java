package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.*;

public class P_13_2_6_ZigZagTraversalOfBinaryTree {

    private static List<List<Integer>> zigzagOrder(Node root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                level.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            if(!leftToRight) Collections.reverse(level);
            zigzag.add(level);
            leftToRight = !leftToRight;
        }
        return zigzag;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);

        List<List<Integer>> zigzag = zigzagOrder(root);
        System.out.println(zigzag);
    }
}