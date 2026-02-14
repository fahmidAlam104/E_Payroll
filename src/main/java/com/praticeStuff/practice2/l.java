package com.praticeStuff.practice2;
import com.praticeStuff.practice.A;

public class l extends A {
    public l(int x) {
        super(x);
    }
    void f(){
        A obj1=new A(1);
        A obj2=new l(2);
        l obj3=new l(3);
       // System.out.println(privAcc+" "+obj1.privAcc+" "+obj2.privAcc+" "+obj3.privAcc);
//        System.out.println(pubAcc +" "+obj1.pubAcc +" "+obj2.pubAcc +" "+obj3.pubAcc);
//        System.out.println(protAcc +" "+obj1.protAcc +" "+obj2.protAcc +" "+obj3.protAcc);
       // System.out.println(defAcc+" "+obj1.defAcc+" "+obj2.defAcc+" "+obj3.defAcc);
    }
}
