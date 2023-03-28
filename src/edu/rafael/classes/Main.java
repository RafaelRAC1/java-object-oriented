package edu.rafael.classes;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();

        car1.setColor("Red");
        car1.setModel("Ford Ranger 2015");
        car1.setTankCapacity(80);

        System.out.println("Car 1\nColor: "+car1.getColor());
        System.out.println("Model: "+car1.getModel());
        System.out.println("Fuel Tank Capacity: "+car1.getTankCapacity()+" liters");
        System.out.println("Fill fuel tank price: "+car1.calculateFillTank(3.7)+" USD");

        System.out.println("---------------------------------");

        Car car2 = new Car("Blue", "Chevrolet Cobalt 2014", 49);

        System.out.println("Car 2\nColor: "+car2.getColor());
        System.out.println("Model: "+car2.getModel());
        System.out.println("Fuel Tank Capacity: "+car2.getTankCapacity()+" liters");
        System.out.println("Fill fuel tank price: "+car2.calculateFillTank(3.7)+" USD");
        
        System.out.println("---------------------------------");
        
        Car car3 = new Car("Orange", "Lamborghini Huracán 2016", 90);

        System.out.println("Car 3\nColor: "+car3.getColor());
        System.out.println("Model: "+car3.getModel());
        System.out.println("Fuel Tank Capacity: "+car3.getTankCapacity()+" liters");
        System.out.println("Fill fuel tank price: "+car3.calculateFillTank(3.7)+" USD");

    }
}
