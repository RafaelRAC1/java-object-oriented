package edu.rafael.collection.streamapi;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
        List<String> randomNumbers = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Print all list elements: ");
        // without lambda
        /*
         * randomNumbers.stream().forEach(new Consumer<String>() {
         * 
         * @Override
         * public void accept(String s) {
         * System.out.println(s);
         * }
         * });
         */

        // with lambda
        // randomNumbers.forEach(s -> System.out.println(s));

        // with reference method
        randomNumbers.forEach(System.out::println);

        System.out.println("Select the first 5 numbers and insert them into a Set:");
        // Set<String> collectSet = randomNumbers.stream().limit(5) //this stores the
        // set
        // .collect(Collectors.toSet());

        randomNumbers.stream().limit(5).collect(Collectors.toSet())
                .forEach(System.out::println);
        ;

        System.out.println("Convert the list from String to int:");
        List<Integer> integerList = randomNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // .forEach(System.out::println);

        System.out.println("Select all even numbers larger than 2 and insert them into a List:");
        List<Integer> collectEvensLargerThan2 = randomNumbers.stream().map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2).collect(Collectors.toList());

        System.out.println(collectEvensLargerThan2);

        System.out.println("Print the avarage: ");
        randomNumbers.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remove all odd numbers: ");
        List<Integer> integerList1 = randomNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        integerList1.removeIf(integer -> integer % 2 != 0);
        System.out.println(integerList);
    }

}