package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P46_InvertBinaryTree {

    /*
        Depth First Search (Recursive)
        TC-> O(n)
        SC-> O(n)
     */
    public static TreeNode invertTreeDFSRecursive(TreeNode root) {
        if(root==null) return root;

        TreeNode temp = root.left;
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
    public static TreeNode invertTreeDFSIterative(TreeNode root){
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;

            if(treeNode.left!=null)stack.push(treeNode.left);
            if(treeNode.right!=null) stack.push(treeNode.right);
        }
        return root;
    }

    /*
        Breadth First Search (Iterative)
        TC-> O(n)
        SC-> O(n)
     */
    public static TreeNode invertTreeBFSIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;

            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }
        return root;

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        TreeNode binaryTree = TreeNode.createBinaryTree(arr);
        TreeNode.printTree(binaryTree);
        System.out.println("----------------------------");
        invertTreeBFSIterative(binaryTree);
        TreeNode.printTree(binaryTree);
    }
}
