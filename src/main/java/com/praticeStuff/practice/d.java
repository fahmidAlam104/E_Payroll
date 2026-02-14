package com.praticeStuff.practice;

@FunctionalInterface
public interface d extends c {
    void f(int a, int b);

    default void g(){
        System.out.println("hi");
    }
}
