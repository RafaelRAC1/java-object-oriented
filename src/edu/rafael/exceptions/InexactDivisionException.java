package edu.rafael.exceptions;

public class InexactDivisionException extends Exception {

    private int numerator;
    private int denominator;

    public InexactDivisionException(String message, int numerator, int denominator) {
        super(message);
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
