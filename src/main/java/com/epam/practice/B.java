package com.epam.practice;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class B extends A implements c,Comparable<B> {

//    @Override
//    public long[] ff(){
//        return new int[10];
//    }

    @Override
    public Integer[] ff2(){

//         Collections.unmodifiableList();
       // List.of()
        return new Integer[10];
    }


    void addNumbers(List<? super Integer> list) {
        list.add(1);        // OK
        list.add(new Integer(2)); // OK
        // Cannot safely read as Integer:
        // Integer num = list.get(0); // Compile error
         Object num = list.get(0);
    }
    //@Override
//    public int meth(List<Integer> ls){
//        return 11;
//    }
//    @SuppressWarnings()
    public Integer sum(int integer1, int integer2,int aa) {
        System.out.println("111");
        return integer1 + integer2;
    }
    public int sum(Integer integer1, Integer integer2) {
        System.out.println("222");
        LinkedList<Integer> a=new LinkedList<>();
        a.add(null);
        new ArrayList<>(List.of(List.of(1,2,3,4), 2,new HashMap<>(),new ArrayList<>(List.of(1)),List.of(5,6)));
        //List<Integer> aa=new ArrayList<>(null);          // Runtime exception: NullPointerException
        Arrays.asList(List.of(1,2,3,4), 2,new HashMap<>(),new ArrayList<>(List.of(1)),List.of(5,6));



        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> l2=new ArrayList<>(list);

   list.add(5);
   l2.forEach(System.out::println);

        System.out.println();

        String s1 = "Java";
        String s2 = "java";
        System.out.println(s1.compareTo(s2));

//        private int x=0;

       // throw new IOException("Null Pointer Exception");


        rec.x=3;


        c.abc();
        int x=0;
       Function<Integer, Integer> function = (Integer i) -> {
            System.out.println("Function called with: " + x);
            if(i==0){
                //throw new IOException("i cannot be zero");
                throw new RuntimeException("i cannot be zero");
            }
            return i * 2;
        };





        return integer1 + integer2;


    }

    void f() throws IOException {
        A obj1=new A(1);
        A obj2=new B();
        B obj3=new B();
      //  System.out.println(privAcc+" "+obj1.privAcc+" "+obj2.privAcc+" "+obj3.privAcc);
        System.out.println(pubAcc +" "+obj1.pubAcc +" "+obj2.pubAcc +" "+obj3.pubAcc);
        System.out.println(protAcc +" "+obj1.protAcc +" "+obj2.protAcc +" "+obj3.protAcc);
        System.out.println(defAcc +" "+obj1.defAcc +" "+obj2.defAcc +" "+obj3.defAcc);
    }



    public B() throws IOException {
        super(6);
        System.out.println("Constructor of B");
        sum(1,2);
        sum(1,2,3);
            //throw new Error("jnczk");         unchecked

    }


    @Override
    public int compareTo(B o) {
        return 0;
    }
}
