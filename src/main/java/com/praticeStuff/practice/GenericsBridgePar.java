package com.praticeStuff.practice;

public class GenericsBridgePar<T> {
    T getValue(){
        System.out.println("Par getVal");
        return null;
    }
    T process(T val){
        System.out.println("par process ");
        return val;
    }
}
