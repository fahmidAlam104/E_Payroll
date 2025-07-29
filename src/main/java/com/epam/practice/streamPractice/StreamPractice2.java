package com.epam.practice.streamPractice;

import com.epam.Models.Employee;
import com.epam.practice.B;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice2 {
    public void practiceStream() {
        List<List<Integer>> ar = new ArrayList<>(List.of(List.of(1,2),List.of(3,4,5),List.of(6,7)));
        Stream<Integer> ans = ar.stream().flatMap(Collection::stream);

        System.out.println(Stream.iterate(1,i->i<=10,i->i+1).toList());


        Stream<Integer> ans1 = ar.stream().<Integer>mapMulti((input, consumer) -> {
            for(Integer element:input) {
                consumer.accept(element);
            }
             }).peek(System.out::print);
        List<Integer> fans=ans1.toList();



        Map<Integer,Integer> mp=new HashMap<>();
        mp.entrySet().stream().map(x->x.getKey()+x.getValue());
        StringBuilder str=new StringBuilder();
        str.append("abc");
        String s="abccc";
        System.out.println();
        Integer tempans=ar.stream().<Integer>mapMulti(Iterable::forEach).reduce(0,(x, y)->x+y,(x,y)->x+y);
        System.out.println("tempans"+tempans);
        UnaryOperator<Integer> uo=x->2*x;

      //  Map<Integer,Integer> mpp=ar.stream().flatMap(x->x.stream()).collect(Collectors.toMap())

        List<Integer> list=new ArrayList<>(List.of(1,3,4));
        list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),listIn->{
           List<Integer> listOut=new ArrayList<>();
            for(Integer element:listIn){
                element=element*2;
            }
            return listIn;
        })).forEach(yy->System.out.println("yy-> "+yy));


        List<String> list1=new ArrayList<>(List.of("aa","bbbb","ccccc"));
        list1.stream().collect(Collectors.collectingAndThen(Collectors.toList(),listIn->{
            List<String> listOut=new ArrayList<>();
            for(String element:listIn){
                element=element+"a";
            }
            return listIn;
        })).forEach(yy->System.out.println("yy-> "+yy));


        Comparator<Employee> cmp2=(o1,o2)->{return 0;};
        Comparator<B> cmp=Comparator.<B>naturalOrder();
        cmp.reversed();


       // Comparator.nullsFirst()

    }
}
