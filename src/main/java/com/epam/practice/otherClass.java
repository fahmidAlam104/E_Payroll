package com.epam.practice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class otherClass{
    public static void main(String[] args) {
//        innerClassTest();
//        diamondMultiMethodInterfaceInherit();
//        tryCatchFinally();
//        operatorPrecedenceInOverloading();
//        genericWithRawAndViceVersa();
          bridgeMethod();

    }

    private static void bridgeMethod() {
        GenericsBridgePar stringGenericsBridgeParRaw=new GenericsBridgePar();
        Object x01=stringGenericsBridgeParRaw.getValue();
        Object x02=stringGenericsBridgeParRaw.process("aba");
        GenericsBridgePar<String> stringGenericsBridgePar=new GenericsBridgePar<>();
        GenericsBridgePar<String> stringGenericsBridgeChild=new GenericsBridgeChild();
        String x1=stringGenericsBridgePar.getValue();
        String x2=stringGenericsBridgePar.process("abb");
        Object x25=stringGenericsBridgePar.process("abb");
        String x3=stringGenericsBridgeChild.getValue();
        String x4 =stringGenericsBridgeChild.process("abc");
        Object x45 =stringGenericsBridgeChild.process("abc");

        //  proof
        for (Method m : GenericsBridgeChild.class.getDeclaredMethods()) {
            System.out.println(m + " synthetic=" + m.isSynthetic());
        }
    }

    private static void genericWithRawAndViceVersa() {
        GenericsBT genericsBT=new GenericsBT();
        // genericsBT.noAssignParameterizedToRaw();
        //genericsBT.noAssignRawToParameterized();
        genericsBT.genericToRawAssign();
    }

    private static void operatorPrecedenceInOverloading() {
        A tt=new A();
        tt.process("Name");
        tt.process(1);
        tt.process(new Object());
        short x=1;
        tt.process(x);
    }

    private static void tryCatchFinally() {
        tryCatchFinally tryCatchFinally=new tryCatchFinally();
        System.out.println(tryCatchFinally.changingValueInFinally());
        System.out.println(tryCatchFinally.changingValueInFinallyAndReturning());
    }

    private static void diamondMultiMethodInterfaceInherit() {
//        ddiamond d=new ddiamond() {
//            @Override
//            public void g() {
//                ddiamond.super.g();
//            }
//        };
//        d.g();
    }

    private static void innerClassTest() {
        PrivateInnerClassTest privateClass=new PrivateInnerClassTest();
        PrivateInnerClassTest.InnerPublicClass a=privateClass.new InnerPublicClass();

        PrivateInnerClassTest.InnerPublicStaticClass.e();

        PrivateInnerClassTest.InnerPublicStaticClass.e();
        PrivateInnerClassTest.InnerPublicStaticClass ff= new PrivateInnerClassTest.InnerPublicStaticClass();
    }
}
