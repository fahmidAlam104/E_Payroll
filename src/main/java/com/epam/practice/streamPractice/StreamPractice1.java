package com.epam.practice.streamPractice;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice1 {
    <T> void print(T[] t){
        for(T x:t){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    <T> void print(Stream<T> st){
        st.toList().forEach((x)->System.out.print(x+" "));
        System.out.println();
    }

    public void practice(){
        System.out.println("------------------- Stream Practice 1 ------------------");
        System.out.println("------------- Creation ----------------");
        List<Integer> list1=List.of(0,1,2,3,2);
        int[] arr=new int[]{4,5,6,7};
        Integer[] arr2=new Integer[]{4,5,6,7};
        Stream<Integer> s1=list1.stream();
        Stream<Integer> s2= Arrays.stream(arr).boxed();
        Stream<Integer> s3= Arrays.stream(arr2);
        Stream<Integer> s4=Stream.of(8,9,10,11);
        Stream<Integer> s5=Stream.generate(()->1).limit(10);
        Stream<Integer> s6=Stream.iterate(1,x->x<=10,i->i+1);
        Stream<Integer> s7=Stream.iterate(1,x->x<=10,i->i+1);


        Object[] arr3 = s7.toArray();


//        print(s1);
//        print(s2);
//        print(s3);
//        print(s4);
//        print(s5);
//        print(s6);
//        print(arr3);
        System.out.println("---------- creation ends -----------");

        List<List<Integer>> list2=List.of(List.of(1,2),List.of(3,4,5),List.of(6,7,8));
        Stream<Integer> flatMap=list2.stream().flatMap(x->x.stream());
        System.out.println("flatmap ");
        print(flatMap);
        IntStream is=list2.stream().flatMapToInt(x->x.stream().mapToInt(y->y));
        Stream<Integer> mapMulti=list2.stream().<Integer>mapMulti((list,consumer)->{
            for(int x:list){
                if(x%2==1){
                    consumer.accept(x);
                }
            }
        });
        System.out.println("mapMulti");
        print(mapMulti);
        Stream<Integer> distinct=list1.stream().distinct();          // hashcode and equal needed
        System.out.println("Distinct");
        print(distinct);
        Stream<Integer> sorted=list1.stream().sorted();             // comparator or comparable
        System.out.println("Sorted");
        print(sorted);

        Stream<Integer> skip=s1.skip(1);
        System.out.println("skip");
        print(skip);

        Stream<Integer> limit=s2.limit(2);
        System.out.println("limit");
        print(limit);

        Stream<Integer> dropWhile=s3.dropWhile(x->x<5);
        System.out.println("dropwhile");
        print(dropWhile);

        Stream<Integer> takeWhile=s4.takeWhile(x->x<=10);
        System.out.println("takewhile");
        print(takeWhile);


        Stream<Integer> concat=Stream.concat(s5,s6);
        System.out.println("concat");
        print(concat);

        List<Integer> list3=Stream.iterate(1,x->x<=5,x->x+1).peek(System.out::println).toList();

        Stream<Integer> empty=Stream.empty();
        System.out.println("empty "+empty);

        System.out.println("Reduce with binary operator    "+list3.stream().reduce((x,y)->x+y).orElse(-1));
        System.out.println("Reduce with identity and binary operator    "+list3.stream().reduce(0,(x,y)->x+y));
        System.out.println("Reduce with identity ,acccumulator and combiner "+list3.parallelStream()
                .reduce(0,(tmpans,currval)->tmpans+currval,(tmpans1,tmpans2)->tmpans1*tmpans2));

        System.out.println("count "+list3.stream().count());
        list3.stream().forEach(System.out::println);


        int mx=list3.stream().mapToInt(x->x).max().orElse(-1);     // max() doesnt work for non-primitive
        int mn=list3.stream().mapToInt(x->x).min().orElse(-1);
        System.out.println(" MAX : - "+mx);
        System.out.println(" MIN : - "+mn);

        Integer mxInteger=list3.stream().max((x1,x2)->x2-x1).orElse(-1);
        System.out.println(" MAX : - "+mxInteger);      // Doesnt work with intStream

        Integer first=list3.stream().findFirst().orElse(-1);
        Integer any=list3.stream().findAny().orElse(-1);
        boolean anyMatch=list3.stream().anyMatch(x->x>=2);
        boolean allMatch=list3.stream().allMatch(x->x>=0);
        boolean noneMatch=list3.stream().noneMatch(x->x>7);
        System.out.println("First "+first+" any "+any+" anyMatch "
                 +anyMatch+" allMatch "+allMatch+" noneMatch "+noneMatch);


        List<Integer> f=list3.stream().collect(Collectors.toList());

        System.out.println("    ----------------  Collectors  -------------------     ");

        List<Integer> lst1=list3.stream().collect(Collectors.toList());          // in intellij Modifiable
        // There are no guarantees on the type, mutability, serializability, or thread-safety of the List returned;
        lst1.set(0,0);
        lst1.add(6);

        List<Integer> lst2=list3.stream().collect(Collectors.toUnmodifiableList());
        //lst2.add(1);
       // lst2.set(1,0);

        Set<Integer> set=list3.stream().collect(Collectors.toSet());   // in intellij modifiable
        //  There are no guarantees on the type, mutability, serializability, or thread-safety of the Set returned
        set.add(6);

        Set<Integer> set1=list3.stream().collect(Collectors.toUnmodifiableSet());
        //  There are no guarantees on the type, mutability, serializability, or thread-safety of the Set returned
       // set1.add(6);


        Set<Integer> set2=list3.stream().collect(Collectors.toCollection(() -> new HashSet<>())); // Controlled way


        Map<Integer,Integer> mp=list3.stream().collect(Collectors.toMap(x->x,x->x,(x,y)->y)); // in intellij modifiable
      // There are no guarantees on the type, mutability, serializability, or thread-safety of the Map returned.
        mp.put(1,1);

        Map<Integer,Integer> mp1=list3.stream().collect(Collectors.toUnmodifiableMap(x->x,x->x,(x,y)->y));
        //mp1.put(1,1);


        List<Integer> lst3=list3.stream().toList();           // Unmodifiable
        //tmp1.set(0,0);
        // tmp1.add(6);

        Long cnt=list3.stream().collect(Collectors.counting());

        String res=list3.stream().map(x->Objects.toString(x))
                 .collect(Collectors.joining(","," {","} "));     // works with string only
        System.out.println("joining "+ res);


        //------------------------------------------------------------------------------------------
        HashSet<Integer> hs=list3.stream().collect(()->new HashSet<>(),
                    (tmpans,currans)->tmpans.add(currans),
                              (x,y)->x.addAll(y));
        System.out.println("Collect another overloaded method "+hs);
        //------------------------------------------------------------------------------------------


       Map<Boolean,List<Integer>> partitionBy=list3.stream().collect(Collectors.partitioningBy(x->x>3));
        System.out.println("Partition By "+partitionBy);

       Map<Integer,Long> groupingBy=list3.stream().collect(Collectors.groupingBy(x->x/2,()-> new HashMap<>(),Collectors.counting()));
        System.out.println("Grouping By "+groupingBy);


        // ------------------------             MAP FACTS ------------------------------
        Map<Integer,Integer> mpp=new HashMap<>(Map.of(1,2,3,4,5,6));        // Map doesnt have streeam
        Map.Entry<Integer,Integer> mxKey=mpp.entrySet().stream()                  // use entrySet() , keySet() , values()
                .max((x,y)->Integer.compare(x.getKey(),y.getKey()))
                .orElse(Map.entry(-1,-1));
        // -----------------------------------------------------------------------------


        System.out.println("-------------------- -----------------------------------");

        IntSummaryStatistics iss=list3.stream().collect(Collectors.summarizingInt(x->x));
        DoubleSummaryStatistics dss=list3.stream().collect(Collectors.summarizingDouble(x->x));
        LongSummaryStatistics lss=list3.stream().collect(Collectors.summarizingLong(x->x));

        double avg=iss.getAverage()+ dss.getAverage()+ lss.getAverage();
        long count=iss.getCount()+ dss.getCount()+ lss.getCount();

        int max=iss.getMax();            // double ka double , long ka long
        int min=iss.getMin();

        long sum=iss.getSum();
        double sumd=dss.getSum();
        long suml=lss.getSum();


        System.out.println("getAverage "+avg);
        System.out.println("getCount "+count);
        System.out.println("getMax "+max);
        System.out.println("getMin "+min);
        System.out.println("getSum "+sum);

        double avgInt=list3.stream().collect(Collectors.averagingInt(x->x));          // averaging double and long
        int sumInt=list3.stream().collect(Collectors.summingInt(x->x));  // summing double and long
        System.out.println("AveragingInt "+avgInt+ " sumInt "+sumInt);


       List<Integer> lst=list3.stream().collect(Collectors.mapping(x->x*2,Collectors.toList()));
        System.out.println("Collectors.mapping "+lst);

        int collectorMax=list3.stream().collect(Collectors.maxBy((x,y)->Integer.compare(x,y))).orElse(-1);
        int collectorMin=list3.stream().collect(Collectors.minBy((x,y)->Integer.compare(x,y))).orElse(-1);
        System.out.println("Collector Max"+collectorMax+"  CollectorMin "+collectorMin);

        List<Integer> collectingAndThen=list3.stream().collect(
                Collectors.collectingAndThen(Collectors.toList(),x->{
                 return x.stream().map(xx->xx*5).toList();
                  }));
        System.out.println("collecting and then "+collectingAndThen);

        List<Integer> collectorFiltering=list3.stream().collect(Collectors.filtering(x->x>1,Collectors.toList()));
        System.out.println("collectorFiltering "+collectorFiltering);


        List<Integer> collectorFlatmapping=list2.stream().collect(Collectors.flatMapping(x->x.stream(),Collectors.toList()));
        System.out.println("collectorFlatmapping "+collectorFlatmapping);


        Object collectorTeeing = list3.stream().collect(Collectors.teeing(Collectors.summingInt(x->x),Collectors.counting(),
                                  (summ,countt)->(summ+countt)/2));
        System.out.println("CollectorTeeing "+collectorTeeing);


        System.out.println("--------------------- Collectors finished -------------------------");

       int[] array={1,2,3,4,5};
       IntStream intStream=Arrays.stream(array);
       IntStream.range(1,11).boxed().collect(Collectors.toList());





    }
}
