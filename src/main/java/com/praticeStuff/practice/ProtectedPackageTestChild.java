package com.praticeStuff.practice;
import com.praticeStuff.practice.learnPortal.ProtectedPackageTest;
public class ProtectedPackageTestChild extends ProtectedPackageTest{

    void g(){

//        ProtectedPackageTest packageTest=new ProtectedPackageTest();
//        packageTest.f();
//        this.f();
//
//        ProtectedPackageTest packageTestParChild=new ProtectedPackageTestChild();
//        packageTestParChild.f();
//        this.f();

        ProtectedPackageTestChild packageTestChild=new ProtectedPackageTestChild();
        packageTestChild.f();
        this.f();
    }
}
