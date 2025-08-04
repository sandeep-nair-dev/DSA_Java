package com.sandeep.java_dsa.random_stuff.factorypattern;

public class FactoryMain {
    public static void main(String[] args) {
        //Normal Zindagi
//        OS obj = new WindowsOS();
//        obj.spec();

        //Mentos Zindagi
        OSFactory osFactory = new OSFactory();
        OS obj = osFactory.getInstance("Open-source");
        obj.spec();
    }
}
