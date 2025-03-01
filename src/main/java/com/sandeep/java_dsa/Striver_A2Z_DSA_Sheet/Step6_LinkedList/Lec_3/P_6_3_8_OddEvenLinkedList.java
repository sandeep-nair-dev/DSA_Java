package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.Lec_3;

import java.util.ArrayList;
import java.util.List;

public class P_6_3_8_OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode head, tail; // head and tail of the LinkedList

    static void PrintList(ListNode head) // Function to print the LinkedList
    {
        ListNode curr = head;
        for (; curr != null; curr = curr.next)
            System.out.print(curr.val + "-->");
        System.out.println("null");
    }

    static void InsertatLast(int value) // Function for creating a LinkedList
    {
        ListNode newnode = new ListNode(value);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else tail = tail.next = newnode;
    }

    //Brute force where we are replacing the data and not technically reordering the nodes
    public static ListNode SegregateToOddEvenNaive() {
        if(head==null || head.next==null) return head;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.val);
        }

        temp = head.next;

        while (temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.val);
        }

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = list.get(i);
            i++;
            temp = temp.next;
        }
        return head;

    }

    /*
    T.C -> O(n/2){while loop} * 2{2 operations in the loop}
    S.C -> O(1)
     */
    public static ListNode SegregateToOddEven() {
        if(head==null || head.next==null) return head;
        ListNode odd = head, even  = head.next, evenHead=head.next;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }


        public static void main(String[] args) {
        InsertatLast(1);
        InsertatLast(2);
        InsertatLast(3);
        InsertatLast(4);
        System.out.println("Initial LinkedList : ");
        PrintList(head);
        ListNode newHead = SegregateToOddEven();
        System.out.println("LinkedList After Segregation ");
        PrintList(newHead);
    }
}
