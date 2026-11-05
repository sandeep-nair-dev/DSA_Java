package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;


public class P50_SameTree {
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p!=null && q==null) || (p==null && q!=null) || (p.val!=q.val)) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7};
        Integer[] arr2 = new Integer[]{1,2,3,4,5,6,7};

        TreeNode tree1 = TreeNode.createBinaryTree(arr1);
        TreeNode tree2 = TreeNode.createBinaryTree(arr2);

        System.out.println(isSameTree(tree1, tree2));
    }
}
