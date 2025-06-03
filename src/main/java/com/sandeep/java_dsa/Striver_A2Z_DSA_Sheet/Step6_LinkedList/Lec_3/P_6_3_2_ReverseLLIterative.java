package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.Lec_3;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.ListNode;

/**
 * <b>Problem Statement</b>
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list. <b>(Iterative)</b></p>
 */
public class P_6_3_2_ReverseLLIterative {

    public static ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode curr = head;
        ListNode prev=null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
}
