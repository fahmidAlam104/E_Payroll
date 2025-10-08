package com.epam.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericsBT {
    public void noAssignParameterizedToRaw(){
        GenericClass<String> stringGenericClass=new GenericClass<>();
        stringGenericClass.setVal("abc");

        GenericClass rawGeneric=stringGenericClass;
        rawGeneric.setVal(1);

        System.out.println("raw gen "+rawGeneric.getVal());
       // System.out.println("string gen "+stringGenericClass.getVal());  // Exception as string class is now having integer
        //    (String) Integer -> Class cast Exception
    }
    public void noAssignRawToParameterized(){
        GenericClass rawGeneric=new GenericClass();
        rawGeneric.setVal(1);

        GenericClass<String> stringGenericClass=rawGeneric;

        System.out.println("raw gen "+rawGeneric.getVal());
       // System.out.println("string gen "+stringGenericClass.getVal());  // Exception as string class is now having integer
        //    (String) Integer -> Class cast Exception
    }

    public void genericInputWithDiffType(){
        GenericClass<Integer> gn=new GenericClass<>();
        Scanner sc=new Scanner(System.in);
       // gn.setVal(sc.next());
    }

    public void genericToRawAssign(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("bcd");
        arrayList.add("def");

        ArrayList list=arrayList;
        list.add(1);

        System.out.println(arrayList.toString());
        // uses stringBuilder append which has Object as overloaded parameter
        System.out.println(list.toString());

        System.out.println(list.get(3));
        //System.out.println(arrayList.get(3));       // class cast exception

    }
}
