package com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step11_Heaps.Lec_2;

import com.sandeep.java_dsa.Striver_A2Z_DSA_Sheet.Step6_LinkedList.ListNode;

import java.util.PriorityQueue;

public class P_11_2_4_MergeMSortedLists {

    private static ListNode getSortedLL(ListNode[] listNodes){
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.data-b.data);
        ListNode ptr;

        for (ListNode listNode : listNodes) {
            ptr = listNode;
            while (ptr != null) {
                pq.offer(ptr);
                ptr = ptr.next;
            }
        }
         ListNode dummy = new ListNode(0);
        ptr=dummy;
        while (!pq.isEmpty()){
            ptr.next=pq.poll();
            ptr= ptr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);

        node11.next=node12;
        node12.next=node13;
        node21.next=node22;
        node22.next=node23;
        node31.next=node32;
        listNodes[0]=node11;
        listNodes[1]=node21;
        listNodes[2]=node31;

        ListNode result = getSortedLL(listNodes);
        result.print();
    }
}
