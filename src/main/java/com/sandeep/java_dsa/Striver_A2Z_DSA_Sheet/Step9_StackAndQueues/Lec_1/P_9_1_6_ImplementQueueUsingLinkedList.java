package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

public class P_9_1_6_ImplementQueueUsingLinkedList {
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

    Node front = null;
    Node rear = null;
    int currSize = 0;

    void enqueue(int x) {
        Node newNode = new Node(x);
        if (newNode == null) {
            System.out.println("Queue is full");
            System.exit(1);
        }
        if (front == null && rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        currSize++;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Empty Queue");
            System.exit(1);
        }
        int result = front.data;
        front = front.next;
        currSize--;
        return result;
    }

    int peek() {
        if (front == null) {
            System.out.println("Empty Queue");
            System.exit(1);
        }
        return front.data;
    }

    int size() {
        return currSize;
    }

    boolean isEmpty() {
        return front == null;
    }
}
