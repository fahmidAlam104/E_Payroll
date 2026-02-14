package com.praticeStuff.practice;

public class tryCatchFinally {
    public int changingValueInFinally(){
        int i=10;
        try{
            return i;
        }
        catch (Exception e){

        }
        finally {
            i=11;
        }
        return 1;
    }

    public int changingValueInFinallyAndReturning(){
        int i=10;
        try{
            return i;
        }
        catch (Exception e){

        }
        finally {
            i=11;
            return i;
        }
       // return 1;
    }
}
