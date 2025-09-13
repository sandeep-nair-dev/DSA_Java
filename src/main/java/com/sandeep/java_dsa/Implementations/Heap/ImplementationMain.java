package com.sandeep.java_dsa.Implementations.Heap;

import java.util.List;

public class ImplementationMain {

    public static void main(String[] args) throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.insert(14);
        minHeap.insert(97);
        minHeap.insert(56);
        minHeap.insert(104);
        minHeap.insert(2);
        minHeap.insert(52);

        System.out.println(minHeap);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());

        System.out.println("-----------HeapSort-------------");

        minHeap.insert(14);
        minHeap.insert(97);
        minHeap.insert(56);
        minHeap.insert(104);
        minHeap.insert(2);
        minHeap.insert(52);
        List<Integer> sortedList = minHeap.heapSort();
        System.out.println(sortedList);
    }
}
