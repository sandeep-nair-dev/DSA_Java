package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

public class P_14_2_8_ConstructABSTFromAPreorderTraversal {

    /*
        Naive Approach:
            TC -> O(N*N)
            SC -> O(1)
     */
    private static Node createBSTFromPreorder(int[] arr){
        if(arr.length==0) return null;
        Node root = new Node(arr[0]);
        for(int i=1;i<arr.length;i++){
            Node temp = root;
            int element = arr[i];
            while (temp!=null){
                if(temp.val<element){
                    if(temp.right==null){
                        temp.right=new Node(element);
                        break;
                    }else temp=temp.right;
                }else{
                    if(temp.left==null){
                        temp.left = new Node(element);
                        break;
                    }else temp=temp.left;
                }
            }
        }
        return root;
    }

    /*
    TODO:
        Better Approach: We have Preorder, we can get the inorder traversal of a BST by sorting the array....and we can create a unique Binary Tree if given Preorder and Inorder, which will be BST in this case
        TC -> O(N * logN) + O(N) {Sorting + Creating the tree}
        SC -> O(N); {To store the inorder array}
     */

    /*
        Optimal Approach: Maintain upper bound for each node, if going left, the previous node is the upper bound and if going right, upper bound will be same as parent's upper bound
        TC -> O(3N) ~= O(N) {At worst case we visit a node 3 times}
        SC -> O(1)
     */

    private static Node createBSTFromPreorderOptimal(int[] arr, int[] ind, int bound){
        if(ind[0]==arr.length || arr[ind[0]]>bound) return null;

        Node newNode = new Node(arr[ind[0]++]);
        newNode.left = createBSTFromPreorderOptimal(arr, ind, newNode.val);
        newNode.right = createBSTFromPreorderOptimal(arr, ind, bound);
        return newNode;
    }

    public static void main(String[] args) {

        int[] preorder = new int[]{8,5,1,7,10,12};
        Node root = createBSTFromPreorder(preorder);
        Node rootOptimal = createBSTFromPreorderOptimal(preorder, new int[]{0}, Integer.MAX_VALUE);
        Node.printTree(root);
        System.out.println("-----------------------------------------------------------------------------------------");
        Node.printTree(rootOptimal);

    }
}