package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step9_StackAndQueues.Lec_1;

public class P_9_1_2_ImplementQueueUsingArray {

    int size = 1000;
    int[] queue = new int[size];
    int front = -1, rear = -1, currSize = 0;

    void push(int x) {
        if (rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = x;
        currSize++;
    }

    int pop() {
        if (front == -1) {
            System.out.println("Error");
            System.exit(1);
        }
        int poppedElement = queue[front];
        currSize--;
        if (currSize == 0) {
            front = -1;
            rear = -1;
        } else {
            front = (front - 1) % size;
        }
        return poppedElement;
    }

    int top() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return queue[front];
    }

    int size() {
        return currSize;
    }

}
