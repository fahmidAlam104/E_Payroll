package com.praticeStuff.newThings.LearnPath.Streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    static String firstNonRepeatedCharacter(String input){
        if(input==null || input.isBlank()) return "No non-repeated character found";
     Character ans= input.chars().mapToObj(x->Character.toLowerCase((char)x))
             .filter(Character::isLetter).collect(Collectors.<Character, Character, Long, Map<Character, Long>>toMap(x->x, x->1L,
                       Long::sum, LinkedHashMap::new))
             .entrySet().stream().filter(x->x.getValue()==1)
             .findFirst().orElse(Map.entry(' ',-1L)).getKey();

       return ans==' '?"No non-repeated character found":""+ans;

    }
    public static void main(String[] args) {
        String input1="swiss";
        String input2="repeated";
        System.out.println(firstNonRepeatedCharacter(input1));
        System.out.println(firstNonRepeatedCharacter(input2));

    }
}
