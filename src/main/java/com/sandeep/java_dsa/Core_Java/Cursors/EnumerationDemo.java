package com.sandeep.java_dsa.Core_Java.Cursors;


import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

    public static void main(String[] args) {
        Vector vec = new Vector();

        vec.add("Sandeep");
        vec.add(20);
        vec.add(48.5);
        System.out.println(vec);

        Enumeration elements = vec.elements();

        System.out.println(elements);

        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }

}
