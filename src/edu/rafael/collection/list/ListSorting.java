package edu.rafael.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given the following informations about random cats, create a list and sort it printing:
 * (name - age - color);
 * 
 * Cat 1 = name: John, Age: 18, Color: Black;
 * Cat 2 = name: Simba, Age: 6, Color: Ginger;
 * Cat 3 = name: John, Age: 12, Color: White;
 * 
 */
public class ListSorting {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>() {
            {
                add(new Cat("John", 18, "Black"));
                add(new Cat("Simba", 6, "Ginger"));
                add(new Cat("John", 12, "White"));
            }
        };

        System.out.println("--\tInput Order\t---");
        System.out.println(cats);

        System.out.println("--\tRandom Order\t---");
        Collections.shuffle(cats);
        System.out.println(cats);

        System.out.println("--\tSort by Name\t---");
        Collections.sort(cats);
        System.out.println(cats);

        System.out.println("--\tSort by Age\t---");
        Collections.sort(cats, new ComparatorAge());
        // cats.sort(new ComparatorAge()); //another way to sort
        System.out.println(cats);

        System.out.println("--\tSort by Color\t---");
        cats.sort(new ComparatorColor());
        System.out.println(cats);

        System.out.println("--\tSort by Name/Color/Age\t---");
        cats.sort(new ComparatorNameColorAge());
        System.out.println(cats);
    }
}

class Cat implements Comparable<Cat> {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return '(' + "name=" + name + ", age=" + age + ", color=" + color + ')';
    }

    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareToIgnoreCase(cat.getName());
    }

}

class ComparatorAge implements Comparator<Cat> {
    @Override
    public int compare(Cat cat1, Cat cat2) {
        return Integer.compare(cat1.getAge(), cat2.getAge());

    }
}

class ComparatorColor implements Comparator<Cat> {
    @Override
    public int compare(Cat cat1, Cat cat2) {
        return cat1.getColor().compareToIgnoreCase(cat2.getColor());
    }
}

class ComparatorNameColorAge implements Comparator<Cat> {
    @Override
    public int compare(Cat cat1, Cat cat2) {
        int name = cat1.getName().compareToIgnoreCase(cat2.getName());
        if (name != 0)
            return name;

        int color = cat1.getColor().compareToIgnoreCase(cat2.getColor());
        if (color != 0)
            return color;

        return Integer.compare(cat1.getAge(), cat2.getAge());

    }
}