package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.Lec_3;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.ListNode;

/**
 * <b>Problem Statement</b>
 * <p>Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.</p>
 */
public class P_6_3_1_MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
