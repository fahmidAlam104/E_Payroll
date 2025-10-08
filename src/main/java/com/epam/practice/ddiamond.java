package com.epam.practice;

public interface ddiamond extends dchild,d{
    @Override
    default void g(){
        //d.super.g();
        dchild.super.g();
        System.out.println("hi");
    }
}
