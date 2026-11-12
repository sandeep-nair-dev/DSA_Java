package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

import java.util.Stack;

public class P57_KthSmallestElementInABST {

    /*
        Recursive DFS
        Avg case TC -> O(h+k)
        Worst case TC -> O(n)
        Avg case SC-> O(h+k)
        Worst case SC -> O(n)
     */
    public void dfs(TreeNode node, int[] tmp){
        if(node==null) return;

        dfs(node.left, tmp);
        if(tmp[0]==0) return;
        tmp[0]-=1;
        if(tmp[0]==0) {
            tmp[1]=node.val;
            return;
        }
        dfs(node.right,tmp);
    }

    public int kthSmallest_recursiveDfs(TreeNode root, int k) {
        int[] tmp = new int[]{k,-1};
        dfs(root,tmp);
        return tmp[1];
    }

    /*
        Iterative DFS
        TC -> O(n)
        SC -> O(n)
     */

    public int kthSmallest_iterativeDfs(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr=root;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr=stack.pop();
            k--;
            if(k==0) return curr.val;

            curr=curr.right;
        }
        return -1;
    }

    /*
        Morris Traversal

     */
    public int kthSmallest_MorrisTraversal(TreeNode root, int k) {
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left==null){
                k--;
                if(k==0) return curr.val;
                curr=curr.right;
            }else{
                TreeNode prev = curr.left;
                while (prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    prev.right=null;
                    k--;
                    if(k==0) return curr.val;
                    curr=curr.right;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // Test Case 1
        //          3
        //        /   \
        //       1     4
        //        \
        //         2

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        int k1 = 1;

        // Test Case 2
        //          5
        //        /   \
        //       3     6
        //      / \
        //     2   4
        //    /
        //   1

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        int k2 = 3;

        // Test Case 3: Single node
        TreeNode root3 = new TreeNode(1);
        int k3 = 1;

        P57_KthSmallestElementInABST solution = new P57_KthSmallestElementInABST();

        System.out.println("Test Case 1:");
        System.out.println("Expected: 1");
        System.out.println("Actual1:   " + solution.kthSmallest_recursiveDfs(root1, k1));
        System.out.println("Actual2:   " + solution.kthSmallest_iterativeDfs(root1, k1));
        System.out.println("Actual3:   " + solution.kthSmallest_MorrisTraversal(root1, k1));

        System.out.println("\nTest Case 2:");
        System.out.println("Expected: 3");
        System.out.println("Actual1:   " + solution.kthSmallest_recursiveDfs(root2, k2));
        System.out.println("Actual2:   " + solution.kthSmallest_iterativeDfs(root2, k2));
        System.out.println("Actual3:   " + solution.kthSmallest_MorrisTraversal(root2, k2));

        System.out.println("\nTest Case 3:");
        System.out.println("Expected: 1");
        System.out.println("Actual1:   " + solution.kthSmallest_recursiveDfs(root3, k3));
        System.out.println("Actual2:   " + solution.kthSmallest_iterativeDfs(root3, k3));
        System.out.println("Actual3:   " + solution.kthSmallest_MorrisTraversal(root3, k3));
    }
}
