package com.praticeStuff.practice;

public interface dchild extends d{
    @Override
    default void g(){
        System.out.println("hello");
    }

}
