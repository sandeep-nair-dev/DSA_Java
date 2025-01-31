package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.*;

public class P_13_2_11_RightLeftViewOfBinaryTree {

    //brute-force: level order traversal of the binary tree, and then take leftmost element of each level for left view and rightmost element of each level for right view

    //slightly better approach: only taking leftmost/rightmost node value, but eventually we are parsing the whole tree
    public static List<Integer> leftView(Node root){
        List<Integer> leftView = new ArrayList<>();
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftView.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return leftView;
    }

    public static List<Integer> rightView(Node root){
        List<Integer> rightView = new ArrayList<>();
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node current=null;
            for (int i = 0; i < size; i++) {
                current= queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            rightView.add(current.val);
        }
        return rightView;
    }

    //optimal method: recursive: in both we have to traverse the whole tree, but in recursive code is a bit clean so that is the advantage

    public static void recursiveLeftView(Node root, List<Integer> leftview, int level){
        if(root==null) return;

        if(leftview.size()==level) leftview.add(root.val);
        if(root.left!=null) recursiveLeftView(root.left, leftview, level+1);
        if(root.right!=null)recursiveLeftView(root.right, leftview, level+1);
    }

    public static void recursiveRightView(Node root, List<Integer> rightView, int level){
        if(root==null) return;

        if(rightView.size()==level) rightView.add(root.val);
        if(root.right!=null)recursiveRightView(root.right, rightView, level+1);
        if(root.left!=null) recursiveRightView(root.left, rightView, level+1);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, null, 2, 3, 4, null, null, 5, 6, null, null, 7, 8, 9, 10, null, null, null, null, 11, 12, null, null, 13, 14};
        Node root = Node.createBinaryTree(arr);
        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        recursiveLeftView(root, leftView, 0);
        recursiveRightView(root, rightView, 0);
        System.out.println("Left-View of Binary Tree: " + leftView);
        System.out.println("Right-View of Binary Tree: " + rightView);
    }
}