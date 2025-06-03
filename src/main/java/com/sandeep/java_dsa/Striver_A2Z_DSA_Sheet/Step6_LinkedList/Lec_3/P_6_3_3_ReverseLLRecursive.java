package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.Lec_3;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step13_BinaryTrees.Node;
import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.ListNode;

/**
 * <b>Problem Statement</b>
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list. <b>(Recursive)</b></p>
 */
public class P_6_3_3_ReverseLLRecursive {

    public static ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode newHead = reverseLinkedList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
