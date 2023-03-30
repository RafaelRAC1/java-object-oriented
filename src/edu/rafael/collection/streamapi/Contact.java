package edu.rafael.collection.streamapi;

import java.util.Objects;

public class Contact {
    private String name;
    private int number;

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact contato = (Contact) o;
        return Objects.equals(name, contato.name) && number == contato.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

}
