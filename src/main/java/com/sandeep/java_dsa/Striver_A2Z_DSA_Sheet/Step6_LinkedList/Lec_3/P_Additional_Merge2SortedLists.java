package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.Lec_3;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.ListNode;

/**
 * <b>Problem Statement</b>
 * <p>You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.</p>
 */
public class P_Additional_Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode prev = null;
        ListNode head = list1;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                prev = list1;
                list1 = list1.next;
            } else {
                ListNode next = list2.next;
                if (prev == null) {
                    head = list2;
                    prev = list2;
                } else {
                    prev.next = list2;
                    prev = list2;
                }
                list2.next = list1;
                list2 = next;
            }
        }
        list1 = prev;
        if (list2 != null) {
            ListNode next = list2.next;
            list1.next = list2;
            list2 = next;
        }
        return head;
    }
}
