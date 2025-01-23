package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_13_1_10_IterativeInOrderTraversal {

    /*
        T.C. -> O(n)
        S.C. -> O(n) ~= O(h) where h=height of binary tree....in the case if root has only left and every subsequent node has 1 left and 1 right
     */
    private static List<Integer> iterativeInOrderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node top = root;
        while(true){
            if(top!=null){
                stack.push(top);
                top=top.left;
            }else{
                if(stack.isEmpty()) break;
                top=stack.pop();
                inOrder.add(top.val);
                top=top.right;
            }
        }
        return inOrder;
    }

        public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = iterativeInOrderTraversal(root);

        System.out.println(result);
        System.out.print("levelOrder Traversal: ");
        result.forEach(p-> System.out.print(p+" "));
        System.out.println();
    }
}
