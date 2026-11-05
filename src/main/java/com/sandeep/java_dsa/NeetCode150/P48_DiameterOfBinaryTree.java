package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P48_DiameterOfBinaryTree {

    // DFS
    // TC -> O(n)
    // SC -> O(n)

    private static int findHeight(TreeNode root, int[] diameter){
        if(root==null) return 0;

        int leftHeight = findHeight(root.left, diameter);
        int rightHeight = findHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }

    private static int findDiameter(TreeNode root){
        int[] diameter = new int[1];
        findHeight(root, diameter);
        return diameter[0];
    }

    // Iterative DFS
    // TC -> O(n)
    // SC -> O(n)
    private static int findDiameter_IterativeDfs(TreeNode root){
        Map<TreeNode, int[]> map = new HashMap<>();
        map.put(null, new int[]{0,0});

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left!=null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if(node.right!=null && !map.containsKey(node.right)){
                stack.push(node.right);
            }else{
                node = stack.pop();

                int[] leftData = map.get(node.left);
                int[] rightData = map.get(node.right);

                int leftHeight = leftData[0];
                int leftDiameter = leftData[1];
                int rightHeight = rightData[0];
                int rightDiameter = rightData[1];

                int height = 1+Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight+rightHeight, leftDiameter+rightDiameter);

                map.put(node, new int[]{height, diameter});

            }
        }
        return map.get(root)[1];
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5};
        TreeNode binaryTree = TreeNode.createBinaryTree(arr);
        TreeNode.printTree(binaryTree);
        System.out.println("--------------------------------------------------");
        System.out.println(findDiameter(binaryTree));
        System.out.println(findDiameter_IterativeDfs(binaryTree));
    }
}
