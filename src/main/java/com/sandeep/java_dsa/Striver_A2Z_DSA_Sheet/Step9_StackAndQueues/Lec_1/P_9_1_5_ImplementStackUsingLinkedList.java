package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;


class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class P_9_1_5_ImplementStackUsingLinkedList {
    Node top = null;
    int currSize = 0;

    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        currSize++;
    }

    int pop() {
        if (top == null) {
            System.out.println("Empty Stack");
            System.exit(1);
        }
        int result = top.data;
        top = top.next;
        currSize--;
        return result;
    }

    int size() {
        return currSize;
    }

    int top() {
        if (top == null) {
            System.out.println("Empty Stack");
            System.exit(1);
        }
        return top.data;
    }
}
