package com.sandeep.java_dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Main {

    class abc{
        final int a;
        int id;
        String name;

        abc(int a) {
            this.a = a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj) return true;
            if(!(obj instanceof abc abc)) return false;
            return this.id==abc.id && this.name.equals(abc.name);
        }
    }

    interface xyz{
        public default void abc(){
            System.out.println("Hello");
        }
    }

    private static int helllo(int a){
        a=10;
        return a+10;
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("Hello world!");
        boolean s=true;
        System.out.println(s);
        final int i;
        i=0;

//        Object o = null;
//
//        Method method = o.getClass().getMethod("Hello", Boolean.class, String.class);
//        Object s1 = method.invoke(o, true, "s");

        final int a=20;
        System.out.println(helllo(a));
    }
}