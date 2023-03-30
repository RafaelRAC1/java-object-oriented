package edu.rafael.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Given a list of 7 scores from a Student {7, 8.5, 9.3, 5, 7, 0, 3.6}, do:

        // List<Double> scores = new ArrayList<>(); //mostly used before java 5.

        // List<Double> scores = new ArrayList<>(); //recommended

        // ArrayList<Double> scores = new ArrayList<>(); //not overally used nor
        // recommended

        // List<Double> scores = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d,
        // 3.6));

        /*
         * List<Double> scores = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);//very
         * limited, as it can't receive nor remove more values
         * scores.add(10d); //this should give an error message
         * System.out.println(scores);
         */

        /*
         * List<Number> scores = List.of(7d, 8.5, 9.3, 5d, 7d, 0); //same as above
         * scores.add(10d);
         * scores.remove(5d);
         * System.out.println(scores);
         */

        // First step
        System.out.println("Create a list and add the seven scores to it:");
        List<Double> scores = new ArrayList<>();
        scores.add(7d);
        scores.add(8.5);
        scores.add(9.3);
        scores.add(5d);
        scores.add(7d);
        scores.add(0d);
        scores.add(3.6);
        System.out.println(scores.toString());

        // Second step
        System.out.println("Print the index of the 5.0 score: " + scores.indexOf(5d));

        // Third step
        System.out.println("Add the score 8.0 into the list with index 4: ");
        scores.add(4, 8d);
        System.out.println(scores);

        // Fourth step
        System.out.println("Change the 5.0 score to 6.0: ");
        scores.set(scores.indexOf(5d), 6d);
        System.out.println(scores);

        // Fifth step
        System.out.println("Check if the 5.0 score is in the list: " + scores.contains(5d));

        // Sixth step
        System.out.println("Print all scores in input order: ");
        for (Double score : scores) {
            System.out.println(score);
        } // we could use toString() instead

        // Seventh step
        System.out.println("Print the third score in the list: " + scores.get(2));
        System.out.println(scores.toString());

        // Eighth step
        System.out.println("Print the lowest score in the list: " + Collections.min(scores));

        // Ninth step
        System.out.println("Print the highest score in the list: " + Collections.max(scores));

        // Tenth step
        System.out.println("Print the sum of all scores: ");
        Iterator<Double> iterator = scores.iterator();
        Double sum = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            sum += next;
        }
        System.out.println(sum);

        // Eleventh step
        System.out.println("Print the average of all scores: " + sum / scores.size());

        // Twelveth step
        System.out.println("Remove the 0.0 score:");
        scores.remove(0d);
        System.out.println(scores);

        // Thirteenth step
        System.out.println("Remove the score of index 0: ");
        scores.remove(0);
        System.out.println(scores);

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
        System.out.println("Remove all values: ");
        scores.clear();
        System.out.println(scores);

        // Sixteenth step
        System.out.println("Check if the list is empty: " + scores.isEmpty());
    }

}