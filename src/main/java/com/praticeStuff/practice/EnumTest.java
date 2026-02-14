package com.praticeStuff.practice;

public enum EnumTest {
   NORTH(10),EAST(20),WEST(30),SOUTH(40);
    private Integer value;
    private EnumTest(int val){
        this.value=val;
    }

    public void printDetails(){
         System.out.println("String "+this.name()+" int: "+this.ordinal()
                 +" EnumTest: "+EnumTest.valueOf(this.name())
                 +" Integer "+this.value);
    }

    public static void printAll(){
        for(EnumTest et:EnumTest.values()){
            System.out.println(et.name()+" "+et.ordinal()+" "+EnumTest.valueOf(et.name()));
        }
    }
}
