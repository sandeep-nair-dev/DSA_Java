package com.sandeep.java_dsa.Implementations.Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap <T extends Comparable>{
    ArrayList<T> list = new ArrayList<>();

    public MaxHeap(){
        list = new ArrayList<>();
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int leftChild(int index){
        return index*2+1;
    }
    private int rightChild(int index){
        return index*2+2;
    }

    private void swap(int i1, int i2){
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    private void upHeap(int index){
        if(index==0) return;
        int parentIndex = parent(index);
        if(list.get(index).compareTo(list.get(parentIndex))>0){
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }
    public void insert(T element){
        list.add(element);
        upHeap(list.size()-1);
    }

    private void downHeap(int index){
        int max = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if(left<list.size() && list.get(left).compareTo(list.get(max))>0){
            max=left;
        }

        if(right<list.size() && list.get(right).compareTo(list.get(max))>0){
            max=right;
        }

        if(index!=max){
            swap(index, max);
            downHeap(max);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Removing element from empty heap");
        }

        T temp = list.getFirst();
        T last = list.removeLast();

        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    public List<T> heapSort() throws Exception {
        List<T> sorted = new ArrayList<>();
        while (!list.isEmpty()){
            sorted.add(this.remove());
        }
        return sorted;
    }
}
