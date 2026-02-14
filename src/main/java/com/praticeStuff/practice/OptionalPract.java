package com.praticeStuff.practice;

import java.util.Optional;

public class OptionalPract {
    public void abc() {
        System.out.println("--------------Optional Pract-------------");
         Optional<Integer> x= Optional.empty();
        //System.out.println(x.get());
        System.out.println(x.isEmpty() +" "+x.isPresent());
        //  x= Optional.of(null);
          x= Optional.ofNullable(null);
        System.out.println(x.isEmpty() +" "+x.isPresent());
       // System.out.println(x.get());


        x=Optional.of(100);

        x.ifPresent(System.out::println);

        x.filter(xx->xx>1);

        x.map(xx-> xx+1);

      x.ifPresent(System.out::println);

   //     System.out.println(x.);
        System.out.println("abc");
    }
}
