package com.epam;
import com.praticeStuff.practice.streamPractice.StreamPractice3;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.*;

//@SpringBootApplication
//@EnableConfigurationProperties({ApplicationProperties.class})
public class Main {

    public class Pair implements Comparable{
        public int x; int y;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Object o) {
            Pair other=(Pair) o;
            if(x<other.x) return -1;
            else if(x==other.x) return Integer.compare(y,other.y);
            else return 1;
        }
    }


    @Value("${spring.application.name:Defalt app}")
    static String notWorkingApplicationName;                 // static value pr kaam nahi karta

    static String applicationName;
    @Value("${spring.application.name:Defalt app}")
    private void setName(String name){
        applicationName=name;
    }

    public static void main(String[] args) throws IOException {

//        Overloading a=new Overloading();
//        a.callFunc("a");
//
//        OverloadingChild b=new OverloadingChild();
//        b.callFunc("b");
//
//        Overloading aa=new OverloadingChild();
//        aa  .callFunc("ab");


        //new Main().f();
//        System.out.println(" notWorkingappname "+notWorkingApplicationName);
//        System.out.println(" appname "+applicationName);
//
//        List<String> tmp=List.of("aa bb cc","bb cd de");
//        System.out.println(tmp.stream().flatMap(x-> Arrays.stream(x.split(" ")).toList().stream()).
//                collect(Collectors.groupingBy(x->x,Collectors.counting())));
//
//
////         ConfigurableApplicationContext ap= SpringApplication.run(Main.class, args);
//
//
//        System.out.println(" appname "+applicationName);    // gets initialized after spring application context is setup
////        for( String s: ap.getBeanDefinitionNames()){
////            System.out.println(" Bean -> "+s);
////        }
    }
    @Bean
    public Scanner getScanner(){
        return new Scanner(System.in);
    }
    @Bean
    public ObjectMapper getObjectMapper(){
        System.out.println("Beans being created ");
        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }















 //////////////////////////////////   Practice shiet /////////////////////////////////////

   void f() throws IOException {
       System.out.println("Thread :" + Thread.currentThread().getName());
//       threadbt tt=new threadbt();
//       tt.ff();
//
//       threadClas tc=new threadClas();
//       tc.start();

//        List<Integer> ar= Arrays.asList(1,2,4,5);
//        Integer [] arr= new Integer[10];
//        B obj=new B();
//        obj.meth(new ArrayList<Number>());
//
//        A obj1=new A(1);
//        obj1.xy(1);
//
//
//
//        d objj = (xx, y)-> {
//            System.out.println("c interface method called");
//            //throw new IOException(" ");
//        };
//
//
//
////        Integer a=new Integer(2);
////        Integer b=new Integer(2);
//        Integer c= Integer.valueOf("2");
//        Integer d=Integer.valueOf("2");
//        Integer e=2;
//        Integer f=e;
//        e=3;
//        System.out.println(e);
//        System.out.println(f);
//        System.out.println(a==b);
//        System.out.println(c==d);
//
//        List<Double> arr2=new ArrayList<>();
////       arr2.add(new Integer(1));
//
//
//        OptionalPract op=new OptionalPract();
//        op.abc();
//
//
//        StreamPract streamPract=new StreamPract();
//        streamPract.practiceStream();

//       StreamPractice1 streamPractice1=new StreamPractice1();
//       streamPractice1.practice();

       StreamPractice3 streamPractice3=new StreamPractice3();
       streamPractice3.f();
   }
}