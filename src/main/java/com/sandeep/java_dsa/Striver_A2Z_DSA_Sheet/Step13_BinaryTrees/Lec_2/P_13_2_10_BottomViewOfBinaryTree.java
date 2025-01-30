package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class P_13_2_10_BottomViewOfBinaryTree {

    public static List<Integer> levelOrder(Node root){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> queue =  new LinkedList<>();
        queue.add(Pair.of(root, 0));
        while (!queue.isEmpty()){
            Pair<Node, Integer> current = queue.poll();
            map.put(current.getRight(), current.getLeft().val);
            if(current.getLeft().left!=null) queue.add(Pair.of(current.getLeft().left, current.getRight()-1));
            if(current.getLeft().right!=null) queue.add(Pair.of(current.getLeft().right, current.getRight()+1));
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, null, 2, 3, 4, null, null, 5, 6, null, null, 7, 8, 9, 10, null, null, null, null, 11, 12, null, null, 13, 14};
        Node root = Node.createBinaryTree(arr);
        System.out.println("Bottom-View of Binary Tree: " + levelOrder(root));
    }
}