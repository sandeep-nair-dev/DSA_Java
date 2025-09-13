package com.sandeep.java_dsa.LeetcodeQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FindMaxDistanceBetween2NodesInBtree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(10);
        head.right = new Node(11);
        head.left.left = new Node(13);
        head.left.right = new Node(12);
        head.right.left = new Node(15);
        head.right.right = new Node(16);


        int node1Val = 13;
        int node2Val=16;

    }
}
