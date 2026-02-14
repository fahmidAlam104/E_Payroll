package com.praticeStuff.practice;

public class AccessModiOverrdingChild extends AccessModiOverrdingPar{
    @Override
    public void a(){
        System.out.println("Child pub a");
    }
    @Override
    protected void b(){
        System.out.println("Child protected b");
    }
//    @Override
//    public void b(){
//        System.out.println("Child protected b");
//    }
//    @Override      - not allowed
//     void b(){
//        System.out.println("Child protected b");
//    }
    @Override
    void c(){
        System.out.println("Child default c");
    }
   // @Override        -> no overrding
    private void d(){
        System.out.println("Child private d");
    }

    // 'overridingGenerics(List<Integer>)' in 'com.epam.practice.AccessModiOverrdingChild'
    // clashes with 'overridingGenerics(List<String>)' in 'com.epam.practice.AccessModiOverrdingPar';
    // both methods have same erasure, yet neither overrides the other
//    public void overridingGenerics(List<Integer> s){
//        System.out.println("Child overrding gen");
//    }

    @Override
    public void e() throws NoSuchMethodError {
        throw new NoSuchMethodError("");
        //System.out.println("Child e");
    }
}
