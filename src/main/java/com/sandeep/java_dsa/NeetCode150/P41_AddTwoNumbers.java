package com.sandeep.java_dsa.NeetCode150;


import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P41_AddTwoNumbers {

    private static ListNode addTwoNumbers_Naive(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null) {
            s1.append(temp1.data);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            s2.append(temp2.data);
            temp2 = temp2.next;
        }

        Integer i1 = Integer.parseInt(s1.reverse().toString());
        Integer i2 = Integer.parseInt(s2.reverse().toString());

        Integer result = i1 + i2;
        String resultantString = new StringBuilder(String.valueOf(result)).reverse().toString();
        ListNode newHead = new ListNode(Integer.parseInt(String.valueOf(resultantString.charAt(0))));
        ListNode ptr = newHead;
        for (int i = 1; i < resultantString.length(); i++) {
            ptr.next = new ListNode(Integer.parseInt(String.valueOf(resultantString.charAt(i))));
            ptr = ptr.next;
        }
        return newHead;
    }

    private static ListNode addTwoNumbers_Iterative(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.data : 0;
            int v2 = (l2 != null) ? l2.data : 0;

            int val = v1 + v2 + carry;

            carry = val / 10;
            val = val % 10;

            curr.next = new ListNode(val);
            curr = curr.next;

            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        LinkedListUtils.insertatLast(head1, 2);
        LinkedListUtils.insertatLast(head1, 3);

        ListNode head2 = new ListNode(4);
        LinkedListUtils.insertatLast(head2, 5);
        LinkedListUtils.insertatLast(head2, 6);
        ListNode resultant = addTwoNumbers_Iterative(head1, head2);

        System.out.print("l1: ");
        LinkedListUtils.printList(head1);
        System.out.print("l2: ");
        LinkedListUtils.printList(head2);
        System.out.print("Resultant: ");
        LinkedListUtils.printList(resultant);
    }
}
