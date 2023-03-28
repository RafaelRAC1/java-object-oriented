package edu.rafael.classes;

class Car {
    String color;
    String model;
    int tankCapacity;

    Car(){
    }

    Car(String color, String model, int tankCapacity){
        this.color = color;
        this.model = model;
        this.tankCapacity = tankCapacity;
    }

    String getColor(){
    return color;
    }

    void setColor(String color){
        this.color = color;
    }

    String getModel(){
        return model;
    }

    void setModel(String model){
        this.model = model;
    }

    int getTankCapacity(){
        return tankCapacity;
    }

    void setTankCapacity(int tankCapacity){
        this.tankCapacity = tankCapacity;
    }

    double calculateFillTank(double fuelPrice){
        return fuelPrice * tankCapacity;
    }

}
