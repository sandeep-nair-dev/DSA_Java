package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;
import com.sandeep.java_dsa.Solution;

import java.util.*;

public class P58_ConstructBinaryTreeFromPreOrderAndInorderTraversal {

    public void helper(TreeNode node, Map<Integer, Integer> preMap, Map<Integer, Integer> inMap, int[] preorder, int[] inorder){
        if(node==null) return;

        int preInd = preMap.get(node.val);
        int inInd = inMap.get(node.val);

        int inorderPrev = inorder[inInd-1];
        TreeNode left = new TreeNode(inorderPrev);
        node.left=left;
        helper(node.left, preMap, inMap, preorder, inorder);

    }

    /*
        Bruteforce DFS
        TC -> O(n^2)
        SC -> O(n^2)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                mid=i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1,mid+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    /*
        DFS + HashMap
     */

    int pre_idx = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();
    private TreeNode dfs_DfsAndHashmap(int[] preorder, int l, int r){
        if (l > r) return null;
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);
        int mid = indices.get(root_val);
        root.left = dfs_DfsAndHashmap(preorder, l, mid - 1);
        root.right = dfs_DfsAndHashmap(preorder, mid + 1, r);
        return root;
    }
    public TreeNode buildTree_DfsAndHashmap(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs_DfsAndHashmap(preorder, 0, inorder.length - 1);
    }

    //--------------------------------

    private static List<Integer> getPreorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    private static List<Integer> getInorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {

        P58_ConstructBinaryTreeFromPreOrderAndInorderTraversal solution = new P58_ConstructBinaryTreeFromPreOrderAndInorderTraversal();

        // Test Case 1
        // Preorder: [3, 9, 20, 15, 7]
        // Inorder:  [9, 3, 15, 20, 7]
        //
        // Constructed Tree:
        //          3
        //        /   \
        //       9     20
        //            /  \
        //           15   7

        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};

        // Test Case 2: Left-skewed tree
        // Preorder: [1, 2, 3, 4]
        // Inorder:  [4, 3, 2, 1]

        int[] preorder2 = {1, 2, 3, 4};
        int[] inorder2 = {4, 3, 2, 1};

        // Test Case 3: Right-skewed tree
        // Preorder: [1, 2, 3, 4]
        // Inorder:  [1, 2, 3, 4]

        int[] preorder3 = {1, 2, 3, 4};
        int[] inorder3 = {1, 2, 3, 4};

        // Test Case 4: Single node
        int[] preorder4 = {1};
        int[] inorder4 = {1};

        // Test Case 5: Empty tree
        int[] preorder5 = {};
        int[] inorder5 = {};

        // Test Case 6: Balanced tree
        // Preorder: [1, 2, 4, 5, 3, 6, 7]
        // Inorder:  [4, 2, 5, 1, 6, 3, 7]
        //
        //          1
        //        /   \
        //       2     3
        //      / \   / \
        //     4   5 6   7

        int[] preorder6 = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder6 = {4, 2, 5, 1, 6, 3, 7};

        // Execute test cases

        System.out.println("========== Test Case 1 ==========");
        TreeNode root1 = solution.buildTree_DfsAndHashmap(preorder1, inorder1);
        System.out.println("Expected Preorder: " + Arrays.toString(preorder1));
        System.out.println("Actual Preorder:   " + getPreorder(root1));
        System.out.println("Expected Inorder:  " + Arrays.toString(inorder1));
        System.out.println("Actual Inorder:    " + getInorder(root1));

        System.out.println("\n========== Test Case 2 ==========");
        TreeNode root2 = solution.buildTree_DfsAndHashmap(preorder2, inorder2);
        System.out.println("Expected Preorder: " + Arrays.toString(preorder2));
        System.out.println("Actual Preorder:   " + getPreorder(root2));
        System.out.println("Expected Inorder:  " + Arrays.toString(inorder2));
        System.out.println("Actual Inorder:    " + getInorder(root2));

        System.out.println("\n========== Test Case 3 ==========");
        TreeNode root3 = solution.buildTree_DfsAndHashmap(preorder3, inorder3);
        System.out.println("Expected Preorder: " + Arrays.toString(preorder3));
        System.out.println("Actual Preorder:   " + getPreorder(root3));
        System.out.println("Expected Inorder:  " + Arrays.toString(inorder3));
        System.out.println("Actual Inorder:    " + getInorder(root3));

        System.out.println("\n========== Test Case 4 ==========");
        TreeNode root4 = solution.buildTree_DfsAndHashmap(preorder4, inorder4);
        System.out.println("Expected Preorder: " + Arrays.toString(preorder4));
        System.out.println("Actual Preorder:   " + getPreorder(root4));
        System.out.println("Expected Inorder:  " + Arrays.toString(inorder4));
        System.out.println("Actual Inorder:    " + getInorder(root4));

        System.out.println("\n========== Test Case 5 ==========");
        TreeNode root5 = solution.buildTree_DfsAndHashmap(preorder5, inorder5);
        System.out.println("Expected Preorder: []");
        System.out.println("Actual Preorder:   " + getPreorder(root5));
        System.out.println("Expected Inorder:  []");
        System.out.println("Actual Inorder:    " + getInorder(root5));

        System.out.println("\n========== Test Case 6 ==========");
        TreeNode root6 = solution.buildTree_DfsAndHashmap(preorder6, inorder6);
        System.out.println("Expected Preorder: " + Arrays.toString(preorder6));
        System.out.println("Actual Preorder:   " + getPreorder(root6));
        System.out.println("Expected Inorder:  " + Arrays.toString(inorder6));
        System.out.println("Actual Inorder:    " + getInorder(root6));
    }
}
