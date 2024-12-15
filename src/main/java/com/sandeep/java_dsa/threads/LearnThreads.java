package com.sandeep.java_dsa.threads;

public class LearnThreads {
    private static class A extends Thread {                                 //make a class as thread by extending Thread class
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi from A");
                try {
                    Thread.sleep(12);                                   // Thread.sleep() puts the thread in waiting stage...time is in milliseconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class B extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello from B");
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class C implements Runnable {                    // internally Thread class implements Runnable, so we can make a class as thread by explicitly implementing the Runnable interface
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi from C");
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Counter {
        int count;

        public synchronized void increment() {                      // synchronized makes sure that the method is accessible by only one thread at a time, hence making it thread-safe
            count++;
        }

        public static void main(String[] args) throws InterruptedException {
//        A a = new A();
//        B b = new B();
//
//        System.out.println(a.getPriority());              // get priority of thread
//        a.setPriority(Thread.MAX_PRIORITY);               // set priority of thread(suggest priority of thread to scheduler
//                                                          //.... priority -> 1 to 10... 1 is least priority and 10 is highest priority
//        System.out.println(a.getPriority());
//        a.start();                                        // start a thread...internally calls the run() method of Runnable interface
//        b.start();

//        Runnable objC = new C();
//        Runnable objD = ()->{
//            for (int i=0;i<5;i++) {
//                System.out.println("Hello from D");
//                try {
//                    Thread.sleep(12);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        Thread t1=new Thread(objC);
//        Thread t2=new Thread(objD);
//        t1.start();
//        t2.start();

            Counter counter = new Counter();
            Runnable objE = () -> {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            };

            Runnable objF = () -> {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            };

            Thread t1 = new Thread(objE);                                           // After creating a class that implements Runnable interface, we create a thread with this runnable object made from runnable class
            Thread t2 = new Thread(objF);

            t1.start();
            t2.start();
//            Thread.sleep(10);

            t1.join();                      // join makes main method wait for thread to finish execution
            t2.join();

            System.out.println(counter.count);
        }
    }
}
