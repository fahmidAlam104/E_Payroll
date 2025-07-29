package com.epam.practice.streamPractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice3 {


    public class Student {
        public String name;        // Student's name
        public int age;            // Student's age
        public List<String> subjects; // List of subjects the student is enrolled in
        public List<Integer> marks;   // Corresponding list of marks for the subjects

        // Constructor
        public Student(String name, int age, List<String> subjects, List<Integer> marks) {
            this.name = name;
            this.age = age;
            this.subjects = subjects;
            this.marks = marks;
        }
    }

    public void f(){
//        Remove duplicates from a string and return characters in the same order.
//        Example Input: "dabfcadef".
//        Example Output: "dabfce".
        String s="dabfcadef";
        System.out.println(" "+Arrays.stream(s.split("")).distinct().collect(Collectors.joining()));

//        Given a sentence, find the word with the highest length.
//        Example Input: "I am interested to grow in my organization".
//        Example Output: "organization".

        s="I am interested to grow in my organization";
        System.out.println(" "+Arrays.stream(s.split(" ")).max((x,y)->Integer.compare(x.length(),y.length())).orElse("  "));

//        Given a sentence, find the 2nd highest length word.
//        Example Input: "I am interested to grow in my organization".
//        Example Output: "interested" (if "organization" is the longest word).

        s="I am interested to grow in my organization";
        System.out.println(" "+Arrays.stream(s.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst().orElse("....."));

        // if we could have multiple same length words and we want to find the words with 2nd
        // highest length
        // s= "hello hi is i";
        // ans= hi , is

        s="I am very interested intarastad in pursuing big goals in my organization";
        System.out.println(Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(String::length))
                .entrySet().stream().sorted((x,y)->-1*Integer.compare(x.getKey(),y.getKey()))
                .skip(1).findFirst().map(x->x.getValue()).
                orElse(Collections.emptyList()));

        //                    or

        List<Integer> uniqueLength=Arrays.stream(s.split(" ")).map(x->x.length()).distinct()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
         int secondLargestLength = uniqueLength.get(1);
        List<String> secondLargestList=Arrays.stream(s.split(" "))
                 .filter(x->x.length()==secondLargestLength)
                .collect(Collectors.toList());

        System.out.println("SecondLargestList "+secondLargestList);
//        Find the length of the longest word in a sentence.
//        Example Input: "I am interested to grow in my organization".
//                Example Output: 12.

        int longestWord=Arrays.stream(s.split(" ")).mapToInt(x->x.length()).max().orElse(-1);

        // Find the length of the 2nd longest word in a sentence.
        int secondLongest=Arrays.stream(s.split(" ")).map(x->x.length())
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);

        System.out.println("LongestWordLength "+longestWord+" secondLongestLength"+secondLongest);

        // Given a sentence, count the occurrences of each word.
        //Example Input: "the quick brown fox jumps over the lazy dog the dog".
        //Example Output: {the=2, quick=1, brown=1, fox=1, jumps=1, over=1, lazy=1, dog=2}.

        s="the quick brown fox jumps over the lazy dog the dog";
        Map<String,Long> freq=Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency "+freq);

//        Count the occurrence of each character in a string.
//                Example Input: "aabbccdeeff".
//                Example Output: {a=2, b=2, c=2, d=1, e=2, f=2}.

      s="aabbccdeeff";
      Map<String,Long> freq1=Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency "+freq1);

//        Find words in a sentence with the maximum number of vowels.
//         Example Input: "The quick brown fox jumps over the lazy dog".
//            Example Output: ["quick", "over", "lazy"].

        s="the quick brown fox jumps over the lazy dog the dog";
        String vowels="aeiouAEIOU";
        List<String> maxVowels=Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(x-> {
                    int cnt = 0;
                    for (int i = 0; i < x.length(); i++) {
                            if (vowels.contains(""+x.charAt(i))) cnt++;
                    }
                    System.out.println(x+" "+cnt);
                    return cnt;
                }
        )).entrySet().stream()
                .max((x,y)->Integer.compare(x.getKey(),y.getKey())).
                orElse(Map.entry(-1,List.of(" "))).getValue();
        System.out.println("maxVowels "+maxVowels);

//        Find and group numbers by the range they belong to (e.g., 0–9, 10–19, etc.).
//        Example Input: {2, 34, 54, 23, 33, 20, 59, 11, 19, 37}.
//        Example Output: {0=[2], 10=[11, 19], 20=[20, 23], 30=[33, 34, 37], 50=[54, 59]}.

      List<Integer> list=List.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37);
      Map<Integer,List<Integer>> ans=list.stream().collect(Collectors.groupingBy(x->x/10*10));
        System.out.println(ans);

//        Convert a List<String> to a List<Integer> by filtering only numeric strings.
//        Example Input: ["as", "123", "32", "2as"].
//        Example Output: [123, 32].

      List<String> list1=List.of("as", "123", "32", "2as");
      List<Integer> ans1=list1.stream().filter(x->{
          boolean ok=true;
          for(int i=0;i<x.length();i++){
              if(!(x.charAt(i)>='0' && x.charAt(i)<='9')){
                  ok=false;
                  break;
              }
          }
          return ok;
      }).map(x->Integer.valueOf(x)).collect(Collectors.toList());
        System.out.println(ans1);

// Find the sum of unique elements in an integer array.
//Example Input: {5, 6, 7, 8, 5, 5, 8, 8, 7}.
//Example Output: 26.

       List<Integer> list11=List.of(5, 6, 7, 8, 5, 5, 8, 8, 7);
       int sum11=list11.stream().mapToInt(x->x).distinct().sum();
        System.out.println("sum11 "+sum11);

// Rearrange a numeric array to form the smallest possible value (sorted lexicographically).
//Example Input: {1, 34, 3, 98, 9, 76, 45, 4}.
//Example Output: 1334457698.
        List<Integer> list12=List.of(1, 34, 3, 98, 9, 76, 45, 4);
        String ans12=list12.stream().map(x->String.valueOf(x)).sorted().collect(Collectors.joining());
        System.out.println("ans12 "+ans12);

        // --------------- gpt said comparator.reverseOrder is wrong and to use (x,y)-> (x+y).compare(y+x);-------------------------------------------------------

//        Rearrange a numeric array to form the largest possible value.
//        Example Input: {1, 34, 3, 98, 9, 76, 45, 4}.
//        Example Output: 998764543431.
        List<Integer> list13=List.of(1, 34, 3, 98, 9, 76, 45, 4);
        String ans13=list13.stream().map(x->""+x).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        System.out.println("ans13 "+ans13);

  //-------------------------------------------------------------------------------------------------

        //From a string, find the first non-repeated character.
        //Example Input: "swiss".
        //Example Output: 'w'.

        String s14="swiss";
        String ans14=Arrays.stream(s14.split(""))
                .collect(Collectors.groupingBy(Function.identity(),()->new LinkedHashMap<String,Long>(),Collectors.counting())).
                entrySet().stream().filter(x->x.getValue()==1).findFirst().orElse(Map.entry("",-1L)).getKey();
        System.out.println("ans14 "+ans14);

//        Check whether two arrays are equal.
//        Example Input:
//        arr1 = {21, 6, 8, 9, 10, 5}
//        arr2 = {10, 21, 5, 8, 6, 9}.
//        Example Output: True.

        //------------------    Look for better ways    ----------------------
        int[] arr1 = {21, 6, 8, 9, 10, 5};
        int[] arr2 = {10, 21, 5, 8, 6, 9};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean arrayEqual= IntStream.range(0,arr1.length).allMatch(x->arr1[x]==arr2[x]);

// ------------------------------ XXXXXXXXXXXXXXXX -----------------------

        //Reverse a string while keeping special characters in position.
        //Example Input: "Swa$pn&il".
        //Example Output: "lin$pa&wS".

        String ss="Swa$pn&il";
        ArrayDeque<Character> letters=ss.chars().filter(x->Character.isLetter(x)).
                mapToObj(x->(char)x).collect(Collectors.toCollection(()->new ArrayDeque<>()));
        System.out.println(letters);

        String reverseSpecialCharacter=IntStream.range(0,ss.length())
                .mapToObj(x->Character.isLetter(ss.charAt(x))?letters.pollLast():ss.charAt(x))
                .map(x->String.valueOf(x)).collect(Collectors.joining());

        System.out.println("ReverseSpecialCharacter "+reverseSpecialCharacter);

// -------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------

        //Split a list of integers into two lists: one containing even numbers, and the other containing odd numbers.
        List<Integer> list17=List.of(1,2,3,4,5,6,7);
        Map<Integer,List<Integer>> ans171=list17.stream().collect(Collectors.groupingBy(x->x%2));
         Map<Integer,List<Integer>> ans172=list17.stream().collect(Collectors.toMap(x->x%2,y->new ArrayList<>(List.of(y))
                 ,(x,y)->{
                 x.addAll(y);
             return x;
         }));
        System.out.println("ans171 "+ans171+" ans172 "+ans172);

        // --------------------       TODO -----------------------------
        //Group students’ marks by subject and find the highest and lowest marks for each student.
        //Example Input:
        //Student A: [Hindi=50, Maths=90, Science=70]
        //Student B: [Hindi=80, Maths=90, Science=70]
        //Example Output:
        //Student A: [Highest=Maths=90, Lowest=Hindi=50]
        //Student B: [Highest=Maths=90, Lowest=Science=70]

        List<Student> students = List.of(
                new Student("Alice", 20, List.of("Math", "English", "Science"), List.of(90, 85, 80)),
                new Student("Bob", 22, List.of("Math", "English", "Science"), List.of(70, 95, 60)),
                new Student("Charlie", 19, List.of("Math", "English", "Science"), List.of(85, 85, 90))
        );

//        students.stream().collect(Collectors.groupingBy(student->student.name
//                ,new HashMap<String,HashMap<String,Integer>>()
//                ,Collectors.(x->{
//            Map<String,Integer> mp=new HashMap<>();
////            int mxMarks=
//            return mp;
//        })));


/// //////////////////////////////////////////////////////////////////////

//        From a list of cities, create a list of cities that start with "M" or "m".
//                Example Input: ["Mumbai", "Munnar", "Chennai", "Hyderabad"].
//        Example Output: ["Mumbai", "Munnar"].

        List<String> cities = List.of("Mumbai", "Munnar", "Chennai", "Hyderabad");
        List<String> ans20=cities.stream().filter(x->x.startsWith("M") || x.startsWith("m"))
                .collect(Collectors.toList());

//Find the 2nd largest number in an array.
        List<Integer> list23=List.of(1,2,4,5,6);
        System.out.println("2nd largest "+list23.stream().sorted().skip(2));

//Find the next greatest element for each element in an array.
//Example Input: {15, 10, 16, 20, 8, 9, 7, 50}.
//Example Output: {15=16, 10=16, 20=50, 8=9, 50=Integer.MAX_VALUE}.




    }
}
