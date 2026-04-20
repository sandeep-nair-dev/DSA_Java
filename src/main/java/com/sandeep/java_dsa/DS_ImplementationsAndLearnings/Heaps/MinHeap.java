package com.sandeep.java_dsa.Implementations.Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable> {
    ArrayList<T> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    private void upHeap(int index) {
        if (index == 0) return;

        int parentIndex = parent(index);
        if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }

    public void insert(T element) {
        list.add(element);
        upHeap(list.size() - 1);
    }

    private void downHeap(int index) {
        int min = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // 2 if conditions because we want to get the minimum value from left and right
        if (left < list.size() && list.get(left).compareTo(list.get(min)) < 0) {
            min = left;
        }

        if (right < list.size() && list.get(right).compareTo(list.get(min)) < 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from empty Heap");
        }

        T temp = list.getFirst();
        T last = list.removeLast();


        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    public List<T> heapSort() throws Exception {
        ArrayList<T> sortedData = new ArrayList<>();

        while (!list.isEmpty()) {
            sortedData.add(this.remove());
        }
        return sortedData;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T element : list) {
            s.append(element).append(" ");
        }
        return s.toString();
    }
}
