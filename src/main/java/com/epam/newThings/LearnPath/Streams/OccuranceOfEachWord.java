package com.epam.newThings.LearnPath.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OccuranceOfEachWord {
    static Map<String,Long> occuranceOfEachWord(List<String> s){
        String reg="[\\s\\p{Punct}]+";
        return s.stream().flatMap(x-> Arrays.stream(x.split(reg)))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(x->x,Collectors.counting()));
    }
    public static void main(String[] args) {
        List<String> s=List.of("Apple and banana are fruits."
                , "I like to eat an apple every day.",
                "Orange is also a fruit, but banana is my favorite.",
                "APPLE pie is delicious!");
        System.out.println(occuranceOfEachWord(s));
    }
}
