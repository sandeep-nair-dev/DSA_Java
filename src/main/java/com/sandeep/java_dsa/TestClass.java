package com.sandeep.java_dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestClass {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            numbers.add(50);
        }
    }
    }
