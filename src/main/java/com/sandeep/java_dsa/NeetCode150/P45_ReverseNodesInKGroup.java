package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P45_ReverseNodesInKGroup {

    // TC -> O(n)
    // SC -> O(1)


    private static ListNode reverseAndAttach(ListNode left, ListNode next){
        ListNode curr=left.next;
        ListNode end=curr;
        ListNode prev=next;
        while (curr!=next){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        left.next=prev;
        return end;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy =  new ListNode(0);
        dummy.next=head;
        ListNode left=dummy;
        ListNode right=dummy;
        while (true){
            int count=0;
            while (count<k){
                if(right==null) {
                    break;
                }
                right=right.next;
                count++;
            }
            if(right==null) {
                break;
            }
            left=reverseAndAttach(left, right.next);
            right=left;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedListUtils.insertatLast(head,2);
        LinkedListUtils.insertatLast(head,3);
        LinkedListUtils.insertatLast(head,4);
        LinkedListUtils.insertatLast(head,5);
        ListNode res= reverseKGroup(head, 2);
        LinkedListUtils.printList(res);
    }
}
