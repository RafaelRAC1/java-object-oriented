package edu.rafael.polymorphismandoverride;

public class Main {
        public static void main(String[] args){
        //polymorphism
        Superclass[] classes = new Superclass[]{new Subclass1(), new Subclass2(), new Superclass()};

        for(Superclass classx : classes){
           classx.method1();
        }

        System.out.println("");

        for(Superclass classx : classes){
            classx.method2();
        }       

        System.out.println("");

        //override
        Subclass2 subClass2 = new Subclass2();
        subClass2.method2();
    }
}