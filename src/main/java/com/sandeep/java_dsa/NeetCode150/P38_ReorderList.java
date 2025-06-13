package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P38_ReorderList {

    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode start = head;
        while (slow.next != null) {
            ListNode temp = slow;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            ListNode toMove = temp.next;
            temp.next = null;
            toMove.next = start.next;
            start.next = toMove;
            start = start.next.next;
        }
    }

    public static void reorderListOptimal(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        LinkedListUtils.insertatLast(head, 1);
        LinkedListUtils.insertatLast(head, 2);
        LinkedListUtils.insertatLast(head, 3);
        LinkedListUtils.insertatLast(head, 4);
        LinkedListUtils.insertatLast(head, 5);
        LinkedListUtils.insertatLast(head, 6);
        System.out.println("Initial LinkedList:\n");
        LinkedListUtils.printList(head);
        reorderListOptimal(head);
        System.out.println("Reordered List:\n");
        LinkedListUtils.printList(head);
    }
}
