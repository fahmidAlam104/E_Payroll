package com.praticeStuff.practice2;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ThreadStartingPoint {
    public static void main(String[] args) throws InterruptedException {
        //startOnOneThread();

        ForkJoinPool forkJoinPool=(ForkJoinPool) Executors.newWorkStealingPool();
        forkJoinPool.execute(()-> System.out.println("mmmm "));

        ForkJoinPool forkJoinPool1=ForkJoinPool.commonPool();

       // forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS); // wait for task


    }

    void f(){
        Character.valueOf('a').equals("c");
        synchronized (this) {
        }

        synchronized (ThreadStartingPoint.class){
        }
    }

    private static void startOnOneThread() {
        Thread t=new Thread();
        t.start();
        //  t.start();                //        IllegalThreadStateException
    }
}
