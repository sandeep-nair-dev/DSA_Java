package com.sandeep.java_dsa.Core_Java.Cursors;

import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        list.add("Sandeep");
        list.add(20);
        list.add(48.5);

        ListIterator listIterator = list.listIterator();

        System.out.println(listIterator);

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println("--------------------------");

        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        System.out.println("-----------------------");

        listIterator.add("Rahul");
        listIterator.add(1423);
        listIterator.add(637);
        listIterator.add(8989);
        System.out.println(list);
        listIterator.next();
        System.out.println(listIterator.next());

        while (listIterator.hasPrevious()){
            listIterator.previous();
        }
        System.out.println(listIterator.hasPrevious());
        System.out.println(listIterator.next());




    }
}
