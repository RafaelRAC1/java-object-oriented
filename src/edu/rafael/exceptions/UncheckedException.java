package edu.rafael.exceptions;

import javax.swing.*;

public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerator: ");
            String b = JOptionPane.showInputDialog("Denominator: ");

            try {
                int result = divide(Integer.parseInt(a), Integer.parseInt(b));
                JOptionPane.showMessageDialog(null, result);
                continueLooping = false;
            } catch (NumberFormatException exception) {
                // exception.getStackTrace(); //this allows to see the stack trace and print the
                // exception;
                JOptionPane.showMessageDialog(null, "Invalid input format. Please, insert an integer number!\n" +
                        exception.getMessage());
            } catch (ArithmeticException exception) {
                JOptionPane.showMessageDialog(null, "It's impossible to divide a number by 0.");
            } finally {
                System.out.println("Reached finally");
            }
        } while (continueLooping);
        System.out.println("End.");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
