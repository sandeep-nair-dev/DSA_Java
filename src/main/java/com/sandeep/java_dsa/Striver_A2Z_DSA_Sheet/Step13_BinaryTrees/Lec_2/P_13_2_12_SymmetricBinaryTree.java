package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class P_13_2_12_SymmetricBinaryTree {

    public static boolean isSymmetric(Node left, Node right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return left.val==right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
        Node root = Node.createBinaryTree(arr);
        System.out.println("Is tree symmetric: " + isSymmetric(root.left, root.right));
    }
}