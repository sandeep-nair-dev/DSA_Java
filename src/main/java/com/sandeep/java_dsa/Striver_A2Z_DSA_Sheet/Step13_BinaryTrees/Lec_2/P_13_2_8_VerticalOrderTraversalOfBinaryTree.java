package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class P_13_2_8_VerticalOrderTraversalOfBinaryTree {

    private static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        inorder(root, map, 0, 0);
        map.values().forEach((value) -> {
            List<Integer> column = new ArrayList<>();
            value.values().forEach((pq) -> {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            });
            verticalOrder.add(column);
        });
        return verticalOrder;
    }

    private static void inorder(Node node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int row, int col) {       //row is x-axis and col is y-axis
        if (node == null) return;

        if (!map.containsKey(row)) map.put(row, new TreeMap<>());
        if (!map.get(row).containsKey(col)) map.get(row).put(col, new PriorityQueue<>());
        map.get(row).get(col).offer(node.val);

        if (node.left != null) inorder(node.left, map, row - 1, col + 1);
        if (node.right != null) inorder(node.right, map, row + 1, col + 1);
    }


    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.left.left = new Node(6);
//        root.left.left.right = new Node(7);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, null, null, 6, 7};
        Node root = Node.createBinaryTree(arr);

        List<List<Integer>> verticalOrder = verticalOrder(root);
        System.out.println("Vertical Order Traversal: " + verticalOrder);
    }
}