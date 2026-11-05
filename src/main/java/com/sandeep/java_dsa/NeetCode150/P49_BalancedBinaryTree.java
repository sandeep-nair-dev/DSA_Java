package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P49_BalancedBinaryTree {

    private static int checkBinaryTreeBalanced(TreeNode root, boolean[] balanced){
        if(root==null || !balanced[0]) return 0;

        int leftHeight = checkBinaryTreeBalanced(root.left, balanced);
        int rightHeight = checkBinaryTreeBalanced(root.right, balanced);

        if(Math.abs(leftHeight - rightHeight) > 1) balanced[0]=false;
        return 1+Math.max(leftHeight, rightHeight);
    }


    public boolean isBalanced_IterativeDFS(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> depths = new HashMap<>();
        TreeNode node=root;
        TreeNode last=null;
        while (!stack.isEmpty() || node!=null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node=stack.peek();
                if(node.right==null || last==node.right){
                    node=stack.pop();
                    int left = depths.getOrDefault(node.left,0);
                    int right = depths.getOrDefault(node.right,0);
                    if(Math.abs(left-right)>1) return false;
                    depths.put(node, 1+Math.max(left, right));
                    last=node;
                    node=null;
                }else{
                    node=node.right;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createBinaryTree(arr);
        TreeNode.printTree(root);

        boolean[] balanced = new boolean[1];
        balanced[0]=true;
        checkBinaryTreeBalanced(root,balanced);
        System.out.println(balanced[0]);
    }
}
