package com.sandeep.java_dsa.NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class P40_CopyLinkedListWithRandomPointer {
    private static class ListNodeWithRandomPointer {
        int data;
        ListNodeWithRandomPointer random;
        ListNodeWithRandomPointer next;

        public ListNodeWithRandomPointer(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }

        public ListNodeWithRandomPointer(int data, ListNodeWithRandomPointer next) {
            this.data = data;
            this.next = next;
            this.random = null;
        }

        public static void printList(ListNodeWithRandomPointer head) // Function to print the LinkedList
        {
            ListNodeWithRandomPointer curr = head;
            for (; curr != null; curr = curr.next)
                System.out.print(curr.data + ":" + (curr.next != null ? curr.next.data : "null") + ":" + (curr.random != null ? curr.random.data : "null") + "-->");
            System.out.println("null");
        }
    }

    public static ListNodeWithRandomPointer deepClone_HashMapTwoPass(ListNodeWithRandomPointer head) {
        Map<ListNodeWithRandomPointer, ListNodeWithRandomPointer> nodeMap = new HashMap<>();
        ListNodeWithRandomPointer temp = head;
        while (temp != null) {
            nodeMap.put(temp, new ListNodeWithRandomPointer(temp.data, temp.next));
            temp = temp.next;
        }
        nodeMap.forEach((k, v) -> v.random = nodeMap.get(k.random));
        return nodeMap.get(head);
    }

    public static ListNodeWithRandomPointer deepClone_HashMapOnePass(ListNodeWithRandomPointer head) {
        Map<ListNodeWithRandomPointer, ListNodeWithRandomPointer> nodeMap = new HashMap<>();
        nodeMap.put(null, null);
        ListNodeWithRandomPointer temp = head;
        while (temp != null) {
            if (!nodeMap.containsKey(temp)) {
                nodeMap.put(temp, new ListNodeWithRandomPointer(0));
            }
            nodeMap.get(temp).data = temp.data;
            if (!nodeMap.containsKey(temp.next)) {
                nodeMap.put(temp.next, new ListNodeWithRandomPointer(0));
            }
            nodeMap.get(temp).next = nodeMap.get(temp.next);
            if (!nodeMap.containsKey(temp.random)) {
                nodeMap.put(temp.random, new ListNodeWithRandomPointer(0));
            }
            nodeMap.get(temp).random = nodeMap.get(temp.random);
            temp = temp.next;
        }
        return nodeMap.get(head);
    }

    public static ListNodeWithRandomPointer deepClone_spaceOptimized(ListNodeWithRandomPointer head) {
        if (head == null) return null;

        ListNodeWithRandomPointer l1 = head;
        while (l1 != null) {
            ListNodeWithRandomPointer l2 = new ListNodeWithRandomPointer(l1.data);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }

        ListNodeWithRandomPointer newHead = head.next;

        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }

        l1 = head;
        while (l1 != null) {
            ListNodeWithRandomPointer l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNodeWithRandomPointer l1 = new ListNodeWithRandomPointer(3);
        ListNodeWithRandomPointer l2 = new ListNodeWithRandomPointer(7);
        ListNodeWithRandomPointer l3 = new ListNodeWithRandomPointer(4);
        ListNodeWithRandomPointer l4 = new ListNodeWithRandomPointer(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        l1.random = null;
        l2.random = l4;
        l3.random = l1;
        l4.random = l2;
        ListNodeWithRandomPointer.printList(l1);
        System.out.println("With HashMap(Two Pass): ");
        ListNodeWithRandomPointer hashMapTwoPass = deepClone_HashMapTwoPass(l1);
        ListNodeWithRandomPointer.printList(hashMapTwoPass);
        System.out.println("With HashMap(One Pass): ");
        ListNodeWithRandomPointer hashMapOnePass = deepClone_HashMapOnePass(l1);
        ListNodeWithRandomPointer.printList(hashMapOnePass);
        System.out.println("Space Optimized: ");
        ListNodeWithRandomPointer spaceOptimized = deepClone_spaceOptimized(l1);
        ListNodeWithRandomPointer.printList(spaceOptimized);
    }
}
