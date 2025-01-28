package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_13_2_5_CheckIfTwoTreesAreIdenticalOrNot {

    public static boolean checkIsIdentical(Node n1, Node n2) {
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null) {return false;}

        return (n1.val==n2.val) && checkIsIdentical(n1.left, n2.left) && checkIsIdentical(n1.right, n2.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.left.left = new Node(6);
        root1.left.left.right = new Node(7);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.left.left = new Node(6);
        root2.left.left.right = new Node(7);

        System.out.println("Are trees identical: " + checkIsIdentical(root1, root2));
    }
}