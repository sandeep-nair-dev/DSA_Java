package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.Node;
import com.sun.source.tree.BreakTree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P46_InvertBinaryTree {

    /*
        Depth First Search (Recursive)
        TC-> O(n)
        SC-> O(n)
     */
    public static Node invertTreeDFSRecursive(Node root) {
        if(root==null) return root;

        Node temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTreeDFSRecursive(root.left);
        invertTreeDFSRecursive(root.right);
        return root;
    }

    /*
        Depth First Search (Iterative)
        TC-> O(n)
        SC-> O(n)
     */
    public static Node invertTreeDFSIterative(Node root){
        if(root==null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null)stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        return root;
    }

    /*
        Breadth First Search (Iterative)
        TC-> O(n)
        SC-> O(n)
     */
    public static Node invertTreeBFSIterative(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        Node binaryTree = Node.createBinaryTree(arr);
        Node.printTree(binaryTree);
        System.out.println("----------------------------");
        invertTreeBFSIterative(binaryTree);
        Node.printTree(binaryTree);
    }
}
