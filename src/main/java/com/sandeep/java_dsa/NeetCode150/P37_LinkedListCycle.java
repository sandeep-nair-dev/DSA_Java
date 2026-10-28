package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P37_LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3,null);
        LinkedListUtils.insertatLast(head,2);
        LinkedListUtils.insertatLast(head,0);
        LinkedListUtils.insertatLast(head,-4);
        head.next.next.next.next=head.next;
        System.out.println(hasCycle(head));
    }
}
