package com.praticeStuff.practice2;

import static java.lang.Thread.sleep;

public class threaadRunale implements Runnable{

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread:: "+Thread.currentThread().getName());
    }
}
