package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;

public class P35_ReverseLinkedList {
    public ListNode reverseListRecursive(ListNode head) {
        if(head==null) return null;

        ListNode newHead=head;
        if(head.next!=null){
            newHead=reverseListRecursive(head.next);
            head.next.next=head;
        }
        head.next=null;

        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
