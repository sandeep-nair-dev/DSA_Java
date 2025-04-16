package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_5_FindKThSmallestLargestElementInBST {

    /*
        Brute Force: Traverse through the tree and store the nodes values in a list, sort the list and take the kth smalles or largest element
        TC -> O(N) + O(N*logN)
        SC -> O(N)
     */

    /*
        Better way: Inorder traversal of a binary search tree is always sorted, so take the inorder traversal and take smallest/largest
        TC -> O(N)
        SC -> O(N)
     */

    /*
        Optimal way: While doing the inorder traversal, maintain a counter and when counter value = k, that node is your answer so return that answer
        TC -> O(N)
        SC -> O(1)

        To get kth largest element, either first traverse to get number of nodes and then find (N-k)th node
        or find the kth element while doing reverse inorder traversal, i.e., Right Node Left
     */

    private static void findKthSmallest(Node root, int[] counter, int k, int[] result) {
        if (root == null || counter[0] >= k) return;

        findKthSmallest(root.left, counter, k, result);
        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }
        findKthSmallest(root.right, counter, k, result);
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        int k = 3;
        Node root = Node.createBinaryTree(arr);
        int[] kthSmallest = new int[]{Integer.MIN_VALUE};
        int[] counter = new int[]{0};
        findKthSmallest(root, counter, k, kthSmallest);
        int[] kthLargest = new int[]{Integer.MIN_VALUE};
        counter = new int[]{0};
        findKthLargest(root, counter, k, kthLargest);
        System.out.println("Kth smallest element: " + kthSmallest[0]);
        System.out.println("Kth largest element: " + kthLargest[0]);
    }

    private static void findKthLargest(Node root, int[] counter, int k, int[] kthLargest) {
        if (root == null || counter[0] >= k) return;

        findKthLargest(root.right, counter, k, kthLargest);
        counter[0]++;
        if (counter[0] == k) {
            kthLargest[0] = root.val;
            return;
        }
        findKthLargest(root.left, counter, k, kthLargest);
    }
}