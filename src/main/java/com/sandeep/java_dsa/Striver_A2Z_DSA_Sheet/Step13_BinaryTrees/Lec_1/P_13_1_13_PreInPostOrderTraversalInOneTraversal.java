package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/*
    Logic/rules:
        0. Initially insert Pair<root, 1>  in the stack<Pair<node, num>>
        Now, while stack is not empty, take the top of the stack and pop it from the stack
        1. If num==1
            a) add the node value to preorder list
            b) increment the num and add the node back to stack
            c) check if the node has left node, if it has....add the left node to the stack with num=1
        2. If num==2
            a) add the node value to inorder list
            b) increment the num and add the node back to the stack
            c) check if the node has a right node, if it has....add the right node to the stack with num=1
        3. If num==3
            a) add the node value to the inorder list
 */
/*
    T.C. -> O(3*n)  {we are traversing 3 times for a single node}
    S.C. -> O(n){Stack space} + O(3*n){for the 3 list in which we are storing the result}
 */
public class P_13_1_13_PreInPostOrderTraversalInOneTraversal {
    private static Map<String, List<Integer>> allTraversalInOneGo(Node root) {

        Stack<Pair<Node, Integer>> stack = new Stack<>();
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        stack.add(Pair.of(root, 1));
        while (!stack.isEmpty()){
            Pair<Node, Integer> top = stack.pop();
            if(top.getRight().equals(1)){
                preOrder.add(top.getLeft().val);
                stack.add(Pair.of(top.getLeft(), top.getRight()+1));
                if(top.getLeft().left!=null){
                    stack.add(Pair.of(top.getLeft().left, 1));
                }
            } else if (top.getRight().equals(2)) {
                inOrder.add(top.getLeft().val);
                stack.add(Pair.of(top.getLeft(), top.getRight()+1));
                if(top.getLeft().right!=null){
                    stack.add(Pair.of(top.getLeft().right,1));
                }
            }else{
                postOrder.add(top.getLeft().val);
            }
        }
        result.put("Preorder", preOrder);
        result.put("Inorder", inOrder);
        result.put("Postorder", postOrder);
        return result;
    }


    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right=new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right=new Node(7);

        Map<String, List<Integer>> result = allTraversalInOneGo(root);

        System.out.println(result);
        result.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }

}
