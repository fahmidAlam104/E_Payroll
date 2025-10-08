package com.epam.practice;

@FunctionalInterface
public interface d extends c {
    void f(int a, int b);

    default void g(){
        System.out.println("hi");
    }
}
