package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data =data;
        this.next=null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public void print(){
        ListNode ptr = this;
        while (ptr!=null){
            System.out.print(ptr.data + " -> ");
            ptr=ptr.next;
        }
        System.out.println("null");
    }
}
