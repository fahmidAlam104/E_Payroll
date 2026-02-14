package com.praticeStuff.practice.learnPortal;

import com.praticeStuff.practice.ProtectedPackageTestChild;

public class ProtectedTestSameClass {
    void g(){
        ProtectedPackageTest packageTest=new ProtectedPackageTest();
        packageTest.f();

        ProtectedPackageTest packageTestParChild=new ProtectedPackageTestChild();
        packageTestParChild.f();


        ProtectedPackageTestChild packageTestChild=new ProtectedPackageTestChild();
        packageTestChild.f();
    }
}
