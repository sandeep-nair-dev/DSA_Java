package com.sandeep.java_dsa.Core_Java.Cursors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        list.add(20);

//        System.out.println("sout: "+ list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        iterator.next();            //Exception: NoSuchElementException

        iterator.remove();
        System.out.println(list);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);


        /*
            Throws ConcurrentModificationException because iterator is iterating the list and list is being modified mid of iteration
         */
        while (iterator.hasNext()){
            int element = iterator.next();
            if(element%2==0){
                list.remove(element);
            }
        }

        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            int element = iterator1.next();
            if(element%2==0){
                iterator1.remove();
            }
        }

        System.out.println(list);


    }
}
