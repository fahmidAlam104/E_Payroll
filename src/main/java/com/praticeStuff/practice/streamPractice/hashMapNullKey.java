package com.praticeStuff.practice.streamPractice;

import java.util.HashMap;
import java.util.TreeMap;

public class hashMapNullKey {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        hm.put(1,2);
        //hm.put(1,null);
        //hm.put(null,1);
        System.out.println(hm);
    }
}
