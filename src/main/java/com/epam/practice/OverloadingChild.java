package com.epam.practice;

public class OverloadingChild extends Overloading{
    @Override
    public void callFunc(String a) {
        System.out.println("B---->");
    }

    @Override
    public Integer callFunc1(String a) {
        System.out.println( " A - - - - >   ");
        return 1;
    }
}
