package com.sandeep.java_dsa.Implementations.Heap;

import java.util.List;

public class ImplementationMain {

    public static void main(String[] args) throws Exception {

        System.out.println("------------MIN HEAP--------------");
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


        System.out.println("------------MAX HEAP--------------");
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.insert(14);
        maxHeap.insert(97);
        maxHeap.insert(56);
        maxHeap.insert(104);
        maxHeap.insert(2);
        maxHeap.insert(52);

        System.out.println(maxHeap);

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());

        System.out.println("-----------HeapSort with elements sorted in descending-------------");

        maxHeap.insert(14);
        maxHeap.insert(97);
        maxHeap.insert(56);
        maxHeap.insert(104);
        maxHeap.insert(2);
        maxHeap.insert(52);
        List<Integer> sortedList2 = maxHeap.heapSort();
        System.out.println(sortedList2);
    }
}
