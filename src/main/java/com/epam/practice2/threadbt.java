package com.epam.practice2;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class threadbt {

    ReentrantLock lock=new ReentrantLock();
    ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    StampedLock stampedLock=new StampedLock();

    public void ff(){
        threaadRunale threaadRunale =new threaadRunale();
        Thread tt=new Thread(threaadRunale);
        tt.start();
//        Thread tt2=new Thread(threaadRunale);
//        tt.run();

        lock.lock();
        lock.unlock();

        readWriteLock.readLock().lock();
        readWriteLock.readLock().unlock();


        readWriteLock.writeLock().lock();
        readWriteLock.writeLock().unlock();



        long version=stampedLock.readLock();
        stampedLock.unlock(version);


        long version2=stampedLock.writeLock();
        stampedLock.unlock(version2);


        long version3=stampedLock.tryOptimisticRead();
        if(stampedLock.validate(version3)){

        }
        else{

        }


        ss();

        System.out.println("Ending "+Thread.currentThread().getName());
    }

    public void ss(){
        ThreadPoolExecutor threadPoolExecutor= new ThreadPoolExecutor(2,3,
                1, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        // ASYNC Task
      Future<Integer> future=threadPoolExecutor.submit(()->{
            System.out.println("Inside a Anonymous impl of Runnablw");
            return 1000;         // not neccsary
        });


        Future<List<String>> ft=threadPoolExecutor.submit(()->{
            List<String> lst=List.of("1","2","3");
            return lst;
        });
        try {
            List<String> answer = ft.get();
        }
        catch (Exception e){

        }



        CompletableFuture<String> asyncTask= CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return "HEllp";
        },threadPoolExecutor).thenApply((String ans)->{
            System.out.println(Thread.currentThread().getName());
            return "aaaa "+ans;
        });
     try {
         System.out.println(asyncTask.get());
     }catch (Exception e){

     }
        CompletableFuture<String> asyncTask1= CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return "HEllp";
        },threadPoolExecutor).thenApplyAsync((String ans)->{
            System.out.println(Thread.currentThread().getName());
            return "aaaa "+ans;
        });
        try {
            System.out.println(asyncTask1.get());
        }catch (Exception e){

        }



        ExecutorService ex=Executors.newFixedThreadPool(3);
    }
}
