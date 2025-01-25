package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_13_1_12_IterativePostOrderTraversalUsing1Stack {

    private static List<Integer> iterativePostOrderTraversal1Stack(Node root) {
        Node curr=root;
        Stack<Node> stack = new Stack<>();
        List<Integer> postOrder = new ArrayList<>();
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                Node temp = stack.peek().right;
                if(temp!=null){
                    curr=temp;
                }else{
                    temp=stack.pop();
                    postOrder.add(temp.val);
                    while (!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.pop();
                        postOrder.add(temp.val);
                    }
                }
            }
        }
        return postOrder;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left=new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);
        root.right=new Node(7);
        root.right.left=new Node(8);

        List<Integer> result = iterativePostOrderTraversal1Stack(root);

        System.out.println(result);
        System.out.print("levelOrder Traversal: ");
        result.forEach(p-> System.out.print(p+" "));
        System.out.println();
    }
}
