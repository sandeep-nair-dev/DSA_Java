package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P47_MaxDepthOfBinaryTree {

    private static int findMaximumDepth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(findMaximumDepth(root.left), findMaximumDepth(root.right));
    }

    private static int maxDepth_Iterativedfs(TreeNode root) {
        if(root==null) return 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(Pair.of(root,1));
        int res=0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> top = stack.pop();
            TreeNode currNode = top.getKey();
            Integer val = top.getValue();
            if(currNode!=null){
                res = Math.max(res, val);
                if(currNode.left!=null) stack.push(Pair.of(currNode.left,val+1));
                if(currNode.right!=null) stack.push(Pair.of(currNode.left, val+1));
            }
        }
        return res;
    }

    private static int maxDepth_Iterativebfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);

        int level=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        TreeNode binaryTree = TreeNode.createBinaryTree(arr);
        System.out.println(findMaximumDepth(binaryTree));
        System.out.println(maxDepth_Iterativedfs(binaryTree));
        System.out.println(maxDepth_Iterativebfs(binaryTree));
    }
}
