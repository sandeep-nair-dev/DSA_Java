package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P39_RemoveNthNodeFromEnd {

    public static ListNode removeNthNodeFromEndOptimal(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode fast=head;
        ListNode slow = dummy;
        while (n>0){
            fast=fast.next;
            n--;
        }
        while (fast!=null){
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        LinkedListUtils.insertatLast(head, 1);
        LinkedListUtils.insertatLast(head, 2);
        LinkedListUtils.insertatLast(head, 3);
        LinkedListUtils.insertatLast(head, 4);
        LinkedListUtils.insertatLast(head, 5);
        LinkedListUtils.insertatLast(head, 6);

        int index=2;
        System.out.println("Initial LinkedList:\n");
        LinkedListUtils.printList(head);
        System.out.println("After removal:\n");
        ListNode newHead = removeNthNodeFromEndOptimal(head, index);
        LinkedListUtils.printList(newHead);
    }
}
