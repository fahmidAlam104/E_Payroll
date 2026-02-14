package com.praticeStuff.practice;

public class GenericsBridgeChild extends GenericsBridgePar<String>{

    @Override
    String getValue(){
        System.out.println("Child getValue ");
        return null;
    }

    @Override
    String process(String val){
        System.out.println("Child process ");
        return val;
    }

}
