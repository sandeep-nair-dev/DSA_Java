package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

public class P_13_1_3_BinaryTreeRepresentation {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int key) {
            this.data = key;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
    }
}
