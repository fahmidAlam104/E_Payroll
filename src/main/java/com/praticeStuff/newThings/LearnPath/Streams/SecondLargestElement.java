package com.praticeStuff.newThings.LearnPath.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class SecondLargestElement {
    static int findSecondLargest(int []arr,int k){
        if(arr==null || arr.length==0 || k<=0) return -1;
        List<Integer> secondLargest=new ArrayList<>(List.of(Integer.MIN_VALUE,Integer.MIN_VALUE));
        Arrays.stream(arr).filter(x->x>=0).boxed()
                .collect(Collectors.toMap
                        (x->x,x->1, Integer::sum, ()->new HashMap<>()))
                .entrySet().stream().filter(x -> x.getValue() <= k).forEach(x->{
                    int val=x.getKey();
                    if(val>secondLargest.get(0)){
                        secondLargest.set(1,secondLargest.get(0));
                        secondLargest.set(0,val);
                    }
                    else if(val>secondLargest.get(1)){
                        secondLargest.set(1,val);
                    }
                });
        return secondLargest.get(1)==Integer.MIN_VALUE?-1:secondLargest.get(1);
    }
    public static void main(String[] args) {
        int []arr={5, 3, 9, 9, 10, 5, 3, 2};
        int k=1;
        System.out.println("Ans:"+ findSecondLargest(arr,k));
    }
}
