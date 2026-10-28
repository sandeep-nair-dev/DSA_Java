package com.sandeep.java_dsa.NeetCode150;

import com.sandeep.java_dsa.NeetCode150.Model.ListNode;
import com.sandeep.java_dsa.NeetCode150.utils.LinkedListUtils;

public class P36_Merge2SortedLinkedLists {
    public static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyNode = new ListNode(0,null);
        ListNode curr=dummyNode;
        while (list1!=null && list2!=null){
            if(list1.val <=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr= curr.next;
        }
        while (list1!=null){
            curr.next=list1;
            list1=list1.next;
            curr=curr.next;
        }
        while(list2!=null){
            curr.next=list2;
            list2=list2.next;
            curr=curr.next;
        }
        return dummyNode.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<=list2.val){
            list1.next=mergeTwoListsRecursive(list1.next, list2);
            return list1;
        }else{
            list2.next=mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }

    }


    public static void main(String[] args) {

    }
}
