package edu.rafael.exceptions;

import javax.swing.*;

public class CustomException_2 {
    public static void main(String[] args) {
        int[] numerator = { 4, 5, 8, 10 };
        int[] denominator = { 2, 4, 0, 2, 8 };

        for (int i = 0; i < denominator.length; i++) {
            try {
                if (numerator[i] % 2 != 0)
                    throw new InexactDivisionException("Inexact Division!", numerator[i], denominator[i]);

                int result = numerator[i] / denominator[i];
                System.out.println(result);
            } catch (InexactDivisionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }

        }
        System.out.println("The program stills...");
    }
}
