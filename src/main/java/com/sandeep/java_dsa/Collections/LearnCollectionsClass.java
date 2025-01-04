package com.sandeep.java_dsa.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnCollectionsClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(66);
        list.add(22);
        list.add(108);
        list.add(34);
        list.add(76);
        list.add(76);
        list.add(76);

        System.out.println("min element: " + Collections.min(list));
        System.out.println("max element: " + Collections.max(list));
        System.out.println(Collections.frequency(list, 76));

        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
