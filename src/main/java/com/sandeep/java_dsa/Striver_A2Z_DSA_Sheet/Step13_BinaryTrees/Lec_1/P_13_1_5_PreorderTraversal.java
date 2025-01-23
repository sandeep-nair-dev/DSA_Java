package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class P_13_1_5_PreorderTraversal {


    public static List<Integer> preOrderRoot(Node root){
        List<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);
        return preOrder;
    }

    public static void preOrderTraversal(Node root, List<Integer> preOrder){
        if(root==null){
            return;
        }

        preOrder.add(root.val);
        preOrderTraversal(root.left, preOrder);
        preOrderTraversal(root.right, preOrder);
    }



    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting preorder traversal
        List<Integer> result = preOrderRoot(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
