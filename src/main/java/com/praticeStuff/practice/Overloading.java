package com.praticeStuff.practice;

public class Overloading {
    public void callFunc(String a) {
        System.out.println( " A - - - - >   ");
    }
    public Object callFunc1(String a) {
        System.out.println( " A - - - - >   ");
        return new String("abc");
    }

    public void func(Number x){
        System.out.println("abc");
    }

    public void func(Integer x){
        System.out.println("abc");
    }
}
