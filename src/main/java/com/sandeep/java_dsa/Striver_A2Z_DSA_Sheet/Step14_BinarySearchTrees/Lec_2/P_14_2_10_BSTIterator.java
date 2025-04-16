package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step14_BinarySearchTrees.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;

import java.util.Stack;


public class P_14_2_10_BSTIterator {

    /*
        Approach 1: Store the inorder traversal while initializing the BST operator in a class scope array and point to first element, everytime next is called return the element and move to next
            TC -> BSTIterator -> O(N)
                  next -> O(1)
                  hasNext -> O(1)
            SC -> O(N)
     */

    /*
        Approach 2: If we are not allowed to store the inorder traversal
        Store all the left nodes in stack while initialization
        while getting the next, take the top element and return its value...also if the element has node to right, add that node and all nodes to the left of that node to the stack
        for hasNext, just check if the stack is empty or not

        TC -> We are pushing but not everytime, so there could be n items pushed and n next calls, so O(n)/O(n)
        so TC on avg comes out to be O(1)                   amortized analysis
        SC -> O(H)      At most we are storing left left left that is at most height of the tree
     */
    Stack<Node> stack = new Stack<>();

    public P_14_2_10_BSTIterator(Node root) {
        pushAllLefts(root);
    }

    public int next() {
        Node element = stack.pop();
        if (element.right != null) pushAllLefts(element.right);
        return element.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLefts(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {

    }
}