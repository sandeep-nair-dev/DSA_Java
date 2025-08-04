package com.sandeep.java_dsa.NeetCode150.utils;


import com.sandeep.java_dsa.NeetCode150.Model.ListNode;

public class LinkedListUtils {
    public static void printList(ListNode head) // Function to print the LinkedList
    {
        ListNode curr = head;
        for (; curr != null; curr = curr.next)
            System.out.print(curr.data + "-->");
        System.out.println("null");
    }

    public static void insertatLast(ListNode head, int value) // Function for creating a LinkedList
    {
        ListNode newnode = new ListNode(value);
        ListNode temp =head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next = newnode;
    }
}
