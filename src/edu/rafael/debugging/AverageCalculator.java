package edu.rafael.debugging;

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] students = { "John", "Adam", "Boron", "Peter" };

        double media = calculateAverageClass(students, scan);

        System.out.printf("Class average %.1f: ", media);
    }

    public static double calculateAverageClass(String[] students, Scanner scan) {
        double sum = 0;
        for (String student : students) {
            System.out.printf("Student score %s: ", student);
            double score = scan.nextDouble();
            sum += score;
        }
        return sum / students.length;
    }
}
