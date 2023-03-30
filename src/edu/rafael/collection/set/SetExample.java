package edu.rafael.collection.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // Given a list of 7 scores from a Student {7, 8.5, 9.3, 5, 7, 0, 3.6}, do:

        // Set scores = new HashSet<>(); //mostly used before java 5.

        // Set<Double> scores = new HashSet<>(); //recommended

        // HashSet<Double> scores = new HashSet<>(); //not overally used nor recommended

        // Set<Double> scores = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d,
        // 3.6));

        /*
         * Set<Double> scores = Set.of(7d, 8.5, 9.3, 5d, 7d, 0); //same as above
         * scores.add(10d);
         * scores.remove(5d);
         * System.out.println(scores);
         */

        // First step
        System.out.println("Create a list and add the seven scores to it:");
        Set<Double> scores = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        System.out.println(scores.toString());

        // Second step - Not possible because HashSet doesn't support indexOf
        // System.out.println("Print the index of the 5.0 score:");

        // Third step - Not possible because HashSet doesn't index manupalation
        // System.out.println("Add the score 8.0 into the list with index 4: ");

        // Fourth step - Not possible, as it doesnt have the set method
        // System.out.println("Change the 5.0 score to 6.0: ");

        // Fifth step
        System.out.println("Check if the 5.0 score is in the list: " + scores.contains(5d));

        // Sixth step
        // System.out.println("Print the third score in the list: "+scores.get(2));
        // System.out.println(scores.toString());

        // Seventh step
        System.out.println("Print the lowest score in the list: " + Collections.min(scores));

        // Eighth step
        System.out.println("Print the highest score in the list: " + Collections.max(scores));

        // Ninth step
        System.out.println("Print the sum of all scores: ");
        Iterator<Double> iterator = scores.iterator();
        Double sum = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            sum += next;
        }
        System.out.println(sum);

        // Tenth step

        // Eleventh step
        System.out.println("Print the average of all scores: " + sum / scores.size());

        // Twelveth step
        System.out.println("Remove the 0.0 score:");
        scores.remove(0d);
        System.out.println(scores);

        // Thirteenth step
        // System.out.println("Remove the score of index 0: ");
        // scores.remove(0);
        // System.out.println(scores);

        // Fourteenth step
        System.out.println("Remove scores lower than 7 and print the list:");
        Iterator<Double> iterator1 = scores.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7d)
                iterator1.remove();
        }
        System.out.println(scores);

        // Fifteenth step
        System.out.println("Print all scores in input order");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);

        // Sixteenth step
        System.out.println("Print all scores in ascending order:");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        // Seventeenth step
        System.out.println("Clear all scores: ");
        scores.clear();

        // Eighteenth step
        System.out.println("Check if the list is empty: " + scores.isEmpty());
    }

}