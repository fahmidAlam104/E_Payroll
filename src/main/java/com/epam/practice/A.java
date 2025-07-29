package com.epam.practice;

import java.util.ArrayList;
import java.util.List;

public class A {
    public A A(){
        return new A(1);
    }
    private int privAcc;
    public int pubAcc;
    protected int protAcc;
     int defAcc;
    public class f{
    }
    private class m{
    }
    protected class n{
    }
     class o{
    }

    public int[] ff(){
        return new int[10];
    }

    public Number[] ff2(){
        return new Number[10];
    }

    public static class g{
    }
    public abstract class h{
    }
    public interface i{
    }
    int y;
    public int meth(List<Number> ls){
        return 1;
    }
//    public int meth(List<Integer> ls){
//        return 1;
//    }
    public void xy(int c){
        System.out.println("Value of c1 is: " + c);
    }
    public void xy(int... c){
        System.out.println("Value of c2 is: " + c);
    }
    public A(int x){
        int y=x;
        System.out.println("Value of y is: " + y);

        StringBuilder sb=new StringBuilder();
        sb.length();
        StringBuffer sb2=new StringBuffer();
        // sb2.



    }
}
