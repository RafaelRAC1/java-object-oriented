package edu.rafael.collection.streamapi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

/*
     * Given the following ids and contacts, create a dictionary and sort
     * it like this: (Name id - Name contact);
     * 
     * id = 1 - Contact = name: Samuel, number: 2222;
    * id = 2 - Contact = name: Cristine, number: 5555;
    * id = 3 - Contact = name: John, number: 1111;

     */
public class ExampleStream {
    public static void main(String[] args) {
        System.out.println("--\tRandom Order\t---");
        Map<Integer, Contact> contacts = new HashMap<>() {
            {
                put(1, new Contact("Samuel", 2222));
                put(4, new Contact("Cristine", 5555));
                put(3, new Contact("John", 1111));
            }
        };
        System.out.println(contacts);
        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getNumber());

        }

        System.out.println("--\tInput Order\t---");
        Map<Integer, Contact> contacts1 = new LinkedHashMap<>() {
            {
                put(1, new Contact("Samuel", 2222));
                put(4, new Contact("Cristine", 5555));
                put(3, new Contact("John", 1111));
            }
        };
        for (Map.Entry<Integer, Contact> entry : contacts1.entrySet()) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getNumber());

        }

        System.out.println("--\tSort by ID\t---");
        Map<Integer, Contact> contacts2 = new TreeMap<>(contacts);
        // System.out.println(contacts2);
        for (Map.Entry<Integer, Contact> entry : contacts2.entrySet()) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getNumber());
        }

        System.out.println("--\tSort by Phone Number\t---");
        /*
         * //Using anonymous class
         * Set<Map.Entry<Integer, Contact>> set = new TreeSet<>(new
         * Comparator<Map.Entry<Integer, Contact>>() {
         * 
         * @Override
         * public int compare(Map.Entry<Integer, Contact> cont1, Map.Entry<Integer,
         * Contact> cont2) {
         * return Integer.compare(cont1.getValue().getNumber(),
         * cont2.getValue().getNumber());
         * }
         * });
         */

        // Using funcional class
        /*
         * Set<Map.Entry<Integer, Contact>> set = new TreeSet<>(Comparator.comparing(
         * new Function<Map.Entry<Integer, Contact>, Integer>() {
         * 
         * @Override
         * public Integer apply(Map.Entry<Integer, Contact> cont) {
         * return cont.getValue().getNumber();
         * }
         * 
         * }));
         */

        // Using lambda expression
        Set<Map.Entry<Integer, Contact>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumber()));

        set.addAll(contacts.entrySet());
        for (Map.Entry<Integer, Contact> entry : set) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getNumber());
        }

        System.out.println("--\tSort by Contact Name\t----");
        Set<Map.Entry<Integer, Contact>> set1 = new TreeSet<>(new ComparatorContactName());
        set1.addAll(contacts.entrySet());
        for (Map.Entry<Integer, Contact> entry : set1) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().getName() + " - " + entry.getValue().getNumber());
        }
    }
}

class ComparatorNumber implements Comparator<Map.Entry<Integer, Contact>> {
    @Override
    public int compare(Map.Entry<Integer, Contact> cont1, Map.Entry<Integer, Contact> cont2) {
        return Integer.compare(cont1.getValue().getNumber(), cont2.getValue().getNumber());
    }
}

class ComparatorContactName implements Comparator<Map.Entry<Integer, Contact>> {
    @Override
    public int compare(Map.Entry<Integer, Contact> cont1, Map.Entry<Integer, Contact> cont2) {
        return cont1.getValue().getName().compareToIgnoreCase(cont2.getValue().getName());
    }
}
