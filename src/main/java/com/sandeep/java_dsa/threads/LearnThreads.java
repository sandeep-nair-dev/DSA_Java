package com.sandeep.java_dsa.threads;

public class LearnThreads {
    private static class A extends Thread{
        public void run()  {
            for (int i=0;i<1000;i++) {
                System.out.println("Hi from A");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class B extends Thread{
        public void run() {
            for (int i=0;i<1000;i++) {
                System.out.println("Hello from B");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        System.out.println(a.getPriority());
        a.setPriority(Thread.MAX_PRIORITY);
        System.out.println(a.getPriority());
        a.start();
        b.start();
    }
}
