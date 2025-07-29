package com.epam.practice2;

public class threadClas extends Thread{
    @Override
    public void run(){
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread:: "+Thread.currentThread().getName());
    }
}
