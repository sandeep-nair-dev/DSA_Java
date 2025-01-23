package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class P_13_1_7_PostOrderTraversal {

    public static List<Integer> postOrderRoot(Node root){
        List<Integer> postOrder = new ArrayList<>();
        postOrderTraversal(root, postOrder);
        return postOrder;
    }

    private static void postOrderTraversal(Node root, List<Integer> postOrder) {
        if(root==null) return;
        postOrderTraversal(root.left, postOrder);
        postOrderTraversal(root.right, postOrder);
        postOrder.add(root.val);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting postOrder traversal
        List<Integer> result = postOrderRoot(root);

        // Displaying the postOrder traversal result
        System.out.print("postOrder Traversal: ");
        // Output each value in the
        // postOrder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
