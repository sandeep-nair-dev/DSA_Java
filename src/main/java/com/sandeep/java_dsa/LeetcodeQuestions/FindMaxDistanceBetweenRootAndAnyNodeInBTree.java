package com.sandeep.java_dsa.LeetcodeQuestions;

public class FindMaxDistanceBetweenRootAndAnyNodeInBTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    private static void findMaxDistance(Node head, int target, int currDistance, int[] maxDistance, boolean[] found){
        if(head==null) return ;
        if(head.data==target){
            found[0]=true;
            maxDistance[0]= Math.max(maxDistance[0], currDistance);
        }
        findMaxDistance(head.left, target, currDistance+1, maxDistance,found);
        findMaxDistance(head.right, target, currDistance+1, maxDistance,found);
    }



    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(10);
        head.right = new Node(11);
        head.left.left = new Node(13);
        head.left.right = new Node(12);
        head.right.left = new Node(15);
        head.right.right = new Node(16);
        head.right.right.right = new Node(13);
        head.left.left.left = new Node(16);

        int target = 16;
        int[] maxDistance = new int[1];
        boolean[] found=new boolean[]{false};
        findMaxDistance(head, target, 0, maxDistance, found);
        System.out.println((found[0])?maxDistance[0]:-1);
    }
}
