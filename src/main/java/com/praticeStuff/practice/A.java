package com.praticeStuff.practice;

import java.util.List;

public class A {
    public A(){

    }
    public static int init(){
        return 12;
    }
    int x=init();
    {
        if(x==1)
       throw new RuntimeException();
    }
    private void privateMethod(){

        final int a;
        a=1;
        System.out.println("Private A Mehtod" + a);
    }


    public A A(){
        return new A(1);
    }
    private int privAcc;
    public int pubAcc;
    protected int protAcc;
     int defAcc;



    public int[] ff(){
        return new int[10];
    }

    public Number[] ff2(){
        return new Number[10];
    }





    public class f{
    }
    private class m{
    }
    protected class n{
    }
     class o{
    }

   public final class j{
   }
//   public final abstract class j2{
//   }

    public static abstract class j3{
    }

    private abstract class j4{
    }

   public final static class k{
   }

   private static final class l{}

    public static class g{
    }
    public abstract class h{
    }
    public static interface i{
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


    // public static native void m();

    public void process(String s){
        System.out.println("String "+s);
    }
    public void process(Integer i){
        System.out.println("Integer "+i);
    }
    public void process(int i){
        System.out.println("int "+i);
    }
    public void process(double i){
        System.out.println("double "+i);
    }
    public <T> void process(T t){
        System.out.println("Type "+t);
    }
//    public <T> int process(T t){
//        System.out.println("Type "+t);
//    }

}
