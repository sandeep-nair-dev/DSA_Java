package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

import java.util.List;
import java.util.PriorityQueue;

public class P44_MergeKSortedLists {

    // TC-> O(n*k)
    // SC -> O(1)
    // Compare first element of each list and take min
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (true) {
            int minNode = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == -1 || lists[minNode].val > lists[i].val) {
                    minNode = i;
                }
            }

            if (minNode == -1) {
                break;
            }
            cur.next = lists[minNode];
            lists[minNode] = lists[minNode].next;
            cur = cur.next;
        }

        return res.next;
    }

    // TC-> O(n*k)
    // SC -> O(1)
    // We merge the first 2 lists which would give a sorted list, we then merge it with 3rd one and so on
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    private static ListNode mergeKLists_Heap(ListNode[] lists){
        if(lists.length==0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode list: lists){
            if(list!=null) minHeap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        while (!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!=null){
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        System.out.println(playground.search(new int[]{1, 3, 5}, 5));
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);

        LinkedListUtils.insertatLast(head1,4);
        LinkedListUtils.insertatLast(head1,5);

        LinkedListUtils.insertatLast(head2,3);
        LinkedListUtils.insertatLast(head2,4);

        LinkedListUtils.insertatLast(head3, 6);

        ListNode[] list = new ListNode[]{head1, head2, head3};

        LinkedListUtils.printList(head1);
        LinkedListUtils.printList(head2);
        LinkedListUtils.printList(head3);
        ListNode res = mergeKLists_Heap(list);
        LinkedListUtils.printList(res);
    }


}
