package com.epam.practice;

public class GenericClass<T> {
    T val;
    public void setVal(T t){
        val=t;
    }
    public T getVal(){
        return val;
    }
}
