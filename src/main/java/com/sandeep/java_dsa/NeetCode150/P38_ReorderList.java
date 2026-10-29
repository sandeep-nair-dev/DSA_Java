package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class P38_ReorderList {

    // Less Optimal - Using Queue or Array
    public void reorderListQueue(ListNode head) {
        Deque<ListNode> queue = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            queue.offer(curr);
            curr = curr.next;
        }
        ListNode dummyNode = new ListNode(0, null);
        curr = dummyNode;
        int idx = 0;
        while (!queue.isEmpty()) {
            if (idx % 2 == 0) curr.next = queue.removeFirst();
            else curr.next = queue.removeLast();
            curr = curr.next;
            curr.next = null;
            idx++;
        }
    }

    // Using Recursion
    public void reorderListRecurse(ListNode head) {
        head=recurse(head, head.next);

    }

    public ListNode recurse(ListNode root, ListNode curr) {
        if (curr == null) return root;

        root = recurse(root, curr.next);
        if (root == null) {
            return null;
        }

        ListNode temp = null;
        if (root == curr || root.next == curr) {
            curr.next = null;
        } else {
            temp = root.next;
            root.next = curr;
            curr.next = temp;
        }
        return temp;
    }

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
