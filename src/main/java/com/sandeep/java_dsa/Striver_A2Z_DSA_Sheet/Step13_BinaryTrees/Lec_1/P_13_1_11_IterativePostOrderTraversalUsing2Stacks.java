package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_13_1_11_IterativePostOrderTraversalUsing2Stacks {

    /*
    T.C. -> O(n)
    S.C. -> O(2*n) + O(n){resultant list}
     */
    private static List<Integer> iterativePostOrderTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root==null) return postOrder;

        st1.push(root);
        while (!st1.isEmpty()){
            Node top = st1.pop();
            st2.add(top.val);
            if(top.left!=null) st1.push(top.left);
            if(top.right!=null) st1.push(top.right);
        }
        while (!st2.isEmpty()){
            postOrder.add(st2.pop());
        }
        return postOrder;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = iterativePostOrderTraversal(root);

        System.out.println(result);
        System.out.print("levelOrder Traversal: ");
        result.forEach(p-> System.out.print(p+" "));
        System.out.println();
    }
}
