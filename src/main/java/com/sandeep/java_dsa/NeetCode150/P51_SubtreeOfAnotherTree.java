package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.TreeNode;

public class P51_SubtreeOfAnotherTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return false;
        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //-------------------------------------------------------------------------

    private String serialize(TreeNode root){
        StringBuilder s = new StringBuilder();
        serialize(root,s);
        return s.toString();
    }

    private void serialize(TreeNode root, StringBuilder s){
        if(root==null){
            s.append("$#");
            return;
        }

        s.append("$").append(root.val);
        serialize(root.left,s);
        serialize(root.right, s);
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot){
        return serialize(root).contains(serialize(subRoot));
    }


}
