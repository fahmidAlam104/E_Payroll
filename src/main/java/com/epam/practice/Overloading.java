package com.epam.practice;

public class Overloading {
    public void callFunc(String a) {
        System.out.println( " A - - - - >   ");
    }
    public Object callFunc1(String a) {
        System.out.println( " A - - - - >   ");
        return new String("abc");
    }
}
