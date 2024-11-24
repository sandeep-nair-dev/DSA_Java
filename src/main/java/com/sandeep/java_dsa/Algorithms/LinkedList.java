package com.sandeep.java_dsa.Algorithms;


class Node{
    int data;
     Node next;

     Node(int data, Node next){
         this.data = data;
         this.next = next;
     }

     Node(int data){
         this.data = data;
         this.next = null;
     }
}
public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        Node y = new Node(arr[3]);
        System.out.println(y.data);
    }

}
