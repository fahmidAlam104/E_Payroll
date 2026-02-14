package com.praticeStuff.practice.learnPortal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StartingPoint {
    public static void main(String[] args) {
        //ImmutableList();
//        String s1 = "this apple is sweet." , s2 = "this apple is sour.";
//        System.out.println(findUniqueWordsInSentences (s1, s2));

        List<Integer> lst=new ArrayList<>(List.of(1, 2, 3, 2, 4, 1));
        System.out.println(getWeightedSum(lst));
    }

    private static Stream<Map.Entry<Integer,Long>> getUniqueElement(List<Integer> lst){
        return lst.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1);
    }

    private static boolean isPrime(int element){
       return IntStream.iterate(2, j -> j < element, j -> j + 1)
                .filter(j -> ((element % j) == 0)).findAny().isEmpty();
    }

    private static Integer getWeightedSum(List<Integer> lst) {
        if(lst==null || lst.size()==0 || !lst.stream().filter(x->(x>100 || x<1)).findAny().isEmpty()){
            throw new IllegalArgumentException("The given list does not follow the constraints");
        }
        return getUniqueElement(lst).map(x -> {
            int sum = IntStream.iterate(2, i -> i <= lst.size(), i -> i + 1).filter(
                    StartingPoint::isPrime
            ).filter(y -> lst.get(y - 1) < x.getKey()).sum();
            return x.getKey() * Math.max(1,sum);
        }).collect(Collectors.summingInt(x -> x));
    }

    private static List<String> findUniqueWordsInSentences (String s1, String s2) {
        if(s1 ==null || s1.length()<1 || s1.length()>200 ||
                s2 ==null || s2.length()<1 || s2.length()>200){
            throw new IllegalArgumentException("Input does not match the constraint");
        }
        return Stream.of(s1, s2)
                .flatMap(s -> Arrays.stream(s.split("[^A-Za-z]+")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    private static void ImmutableList() {
        ImmutableList lst=new ImmutableList(new ArrayList<>(List.of(1,2,3,4,5)));
        if(lst==null){
            throw new IllegalArgumentException("Input cant be null");
        }
        ImmutableListNode curr=lst.getCurr();
        ArrayDeque<Integer> st=new ArrayDeque<>();
        while(curr!=null){
            st.offerLast(curr.getData());
            curr=curr.getNextNode();
        }
        while (st.size()!=0){
            System.out.println(st.pollLast());
        }
    }
}
