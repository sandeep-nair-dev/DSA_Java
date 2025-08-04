package com.sandeep.java_dsa.random_stuff;

public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance_NotThreadSafe(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    public static synchronized Singleton getInstance_ThreadSafeButBlocksReadsToo() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance_OptimalUsingDoubleChecking(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null) instance = new Singleton();
            }
        }
        return instance;
    }
}

// Singleton using enum.....enum has by default private constructor...
enum SingetonEnum{
    INSTANCE;
    int i;

    public void print(){
        System.out.println(i);
    }
}

class Main {
    public static void main(String[] args) {

    }
}
