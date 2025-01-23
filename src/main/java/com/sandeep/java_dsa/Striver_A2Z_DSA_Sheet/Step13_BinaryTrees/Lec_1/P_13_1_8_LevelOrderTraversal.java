package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_1;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_13_1_8_LevelOrderTraversal {

    private static List<List<Integer>> levelOrderRoot(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node currentNode = queue.poll();
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
                level.add(currentNode.val);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting levelOrder traversal
        List<List<Integer>> result = levelOrderRoot(root);

        // Displaying the levelOrder traversal result
        // Output each value in the
        // levelOrder traversal result
        System.out.println(result);
        System.out.print("levelOrder Traversal: ");
        result.forEach(t -> t.forEach(p-> System.out.print(p+" ")));
        System.out.println();
    }

}
