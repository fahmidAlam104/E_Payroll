package com.praticeStuff.practice;

import java.util.List;

public class AccessModiOverrdingPar {
    public void a(){
        System.out.println("Par pub a");
    }
    protected void b(){
        System.out.println("Par protected b");
    }
     void c(){
         System.out.println("Par default c");
     }
    private void d(){
        System.out.println("Par private d");
    }
    public void overridingGenerics(List<String> s){
        System.out.println("Par overrding gen");
    }

    public void e() throws RuntimeException{
        System.out.println("Child e");
    }

}
