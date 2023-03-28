package edu.rafael.upcastanddowncast;

public class Main {
    public static void main(String[] args){
    
    Employee employee = new Employee();

    //upcast
    Employee manager = new Manager();
    Employee seller = new Seller();
    Employee janitor = new Janitor();

    //downcast
    //Seller seller1 = (Seller) new Employee();
    }
}
