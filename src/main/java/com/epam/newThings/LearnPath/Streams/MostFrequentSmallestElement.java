package com.epam.newThings.LearnPath.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentSmallestElement {
    static int mostFrequentSmallestElement(int []arr,int threshold){
        if(arr==null || arr.length==0 || threshold<0 ) return -1;
        return Arrays.stream(arr)
                .filter(x->x>0)
                .boxed()
                .collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()<=threshold)
                .collect(Collectors.toMap(x->x.getValue(),x->x.getKey(),
                        (x,y)->Math.min(x,y),TreeMap::new)).entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getKey))
                .orElse(Map.entry(-1L,-1))
                .getValue();
    }
    public static void main(String[] args) {
        int []arr={1, 3, 2, 1, 4, 1, 3, 3, 3};
        int threshold =4;
        System.out.println("Ans:"+ mostFrequentSmallestElement(arr,threshold ));
    }
}
