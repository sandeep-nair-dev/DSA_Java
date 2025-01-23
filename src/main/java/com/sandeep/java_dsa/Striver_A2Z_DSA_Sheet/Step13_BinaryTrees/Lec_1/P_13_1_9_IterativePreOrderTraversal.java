package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_13_1_9_IterativePreOrderTraversal {

    /*
        T.C. -> O(n)
        S.C. -> O(n) ~= O(h) where h=height of binary tree....in the case if root has only left and every subsequent node has 1 left and 1 right
     */
    private static List<Integer> iterativePreOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            preOrder.add(top.val);
            if (top.right != null) stack.add(top.right);
            if (top.left != null) stack.add(top.left);
        }
        return preOrder;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = iterativePreOrderTraversal(root);


        System.out.println(result);
        System.out.print("levelOrder Traversal: ");
        result.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

}
