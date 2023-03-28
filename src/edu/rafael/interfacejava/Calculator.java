package edu.rafael.interfacejava;

class Calculator implements MathOperations{
    
    @Override
    public void add(double a, double b) {
        System.out.println("Sum: "+(a + b));
    }

    @Override
    public void subtraction(double a, double b) {
        System.out.println("Subtraction: "+(a - b));
    }

    @Override
    public void multiplication(double a, double b) {
        System.out.println("Multiplication: "+(a * b));
    }

    @Override
    public void division(double a, double b) {
        System.out.println("Division: "+(a / b));
    }
}
