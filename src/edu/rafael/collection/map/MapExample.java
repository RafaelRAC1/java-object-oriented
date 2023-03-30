package edu.rafael.collection.map;

import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.sound.sampled.SourceDataLine;

/*
 * Given the car models and their fuel consumption, do:
 * model = neon - consumption: 7.2 km/l
 * model = mini cooper - consumption: 16.3 km/l
 * model = civic - consumption: 16.5 km/l
 * model = focus - consumption: 8.8 km/l
 * model = twingo - consumption: 9.7 km/l
 */

class MapExample {
    public static void main(String[] args) {
        // Map popularCars = new HashMap<>(); //mostly used before java 5.

        // Map<String, Double> popularCars = new HashMap<>(); //recommended

        // HashMap<String, Double> popularCars = new HashMap<>(); //not overally used
        // nor recommended

        // Map<String, Double> popularCars = Map.of("neon", 7.2, "mini cooper", 16.3,
        // "civic", 16.5, "focus", 8.8, "twingo", 9.7);

        System.out.println("Create a dictonary that relates car models to their respective consumptions: ");
        Map<String, Double> popularCars = new HashMap<>() {
            {
                put("neon", 7.2);
                put("mini cooper", 16.3);
                put("civic", 16.5);
                put("focus", 8.8);
                put("twingo", 9.7);
            }
        };
        System.out.println(popularCars.toString());

        System.out.println("Change the neon consumption to 15.2 km/l: ");
        popularCars.put("neon", 15.2);

        System.out
                .println("Check if the model Tucson is already in the database: " + popularCars.containsKey("tucson"));

        System.out.println("Print the civic consumption: " + popularCars.get("civic"));

        // System.out.println("Print the third add model:");//not possible

        System.out.println("Print all cars models: ");
        Set<String> models = popularCars.keySet();
        System.out.println(models);

        System.out.println("Print all cars comsuptions: ");
        Collection<Double> values = popularCars.values();
        System.out.println(values);

        System.out.println("Print the most fuel efficient model and its consumption: ");
        Double mostEfficientConsumption = Collections.max(popularCars.values());
        Set<Map.Entry<String, Double>> entries = popularCars.entrySet();
        String mostEfficientModel = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(mostEfficientConsumption)) {
                mostEfficientModel = entry.getKey();
                System.out.println(
                        "Most efficient model: " + mostEfficientModel + ", " + mostEfficientConsumption + " km/l");
            }
        }

        System.out.println("Print the least fuel efficient model and its consumption:");
        Double leastEfficientConsumption = Collections.min(popularCars.values());
        String leastEfficientModel = "";
        for (Map.Entry<String, Double> entry : popularCars.entrySet()) {
            if (entry.getValue().equals(leastEfficientConsumption)) {
                leastEfficientModel = entry.getKey();
                System.out.println(
                        "Least efficient model: " + leastEfficientModel + ", " + leastEfficientConsumption + " km/l");
            }
        }

        Iterator<Double> iterator = popularCars.values().iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println("Print the sum of the fuel comsumptions: " + sum);

        System.out.println("Print the avarage of the fuel comsumptions: " + sum / popularCars.size());

        System.out.println("Remove all models with consumption equal to 16.5 km/l:");
        Iterator<Double> iterator1 = popularCars.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(16.5))
                iterator1.remove();
        }
        System.out.println(popularCars);

        System.out.println("Print all cars in input order: ");
        Map<String, Double> popularCars1 = new LinkedHashMap<>() {
            {
                put("neon", 7.2);
                put("mini cooper", 16.3);
                put("civic", 16.5);
                put("focus", 8.8);
                put("twingo", 9.7);
            }
        };
        System.out.println(popularCars1.toString());

        System.out.println("Print sorted by car models: ");
        Map<String, Double> popularCars2 = new TreeMap<>(popularCars1);
        System.out.println(popularCars2.toString());

        System.out.println("Clear the dictionary: ");
        popularCars.clear();

        System.out.println("Check if the dictionary is empty: " + popularCars.isEmpty());
    }
}
