package edu.rafael.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapSorting {
    /*
     * Given the following informations about my favorite books and their authors,
     * create
     * a dictionary and sort them:
     * 
     * Author = Hawking, Stephen - Book = name: A Brief History of Time. Pages: 256;
     * Author = Orwell. George - Book = 1984. Pages: 328;
     * Author = Poe, Edgar Allan - Book = name: The Black Cat. Pages: 40;
     */

    public static void main(String[] args) {
        System.out.println("--\tRandom Order\t---");
        Map<String, Book> books = new HashMap<>() {
            {
                put("Hawking, Stephen", new Book("A brief history of time", 256));
                put("Orwell, George", new Book("1984", 256));
                put("Poe, Edgar Allan", new Book("The Black Cat", 40));
            }
        };
        for (Map.Entry<String, Book> book : books.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getBookName());
        }

        System.out.println("--\tInput Order\t---");
        Map<String, Book> books1 = new LinkedHashMap<>() {
            {
                put("Hawking, Stephen", new Book("A brief history of time", 256));
                put("Orwell, George", new Book("1984", 256));
                put("Poe, Edgar Allan", new Book("The Black Cat", 40));
            }
        };
        for (Map.Entry<String, Book> book : books1.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getBookName());
        }

        System.out.println("--\tSort by Author Name\t---");
        Map<String, Book> books2 = new TreeMap<>(books1);
        for (Map.Entry<String, Book> book : books2.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getBookName());
        }

        System.out.println("--\tSort by Book Name\t---");
        Set<Map.Entry<String, Book>> books3 = new TreeSet<>(new ComparatorBookName());
        books3.addAll(books.entrySet());

        for (Map.Entry<String, Book> book : books3) {
            System.out.println(book.getKey() + " - " + book.getValue().getBookName());
        }
    }
}

class Book implements Comparable<Book> {
    private String bookName;
    private double pages;

    public Book(String bookName, double pages) {
        this.bookName = bookName;
        this.pages = pages;
    }

    public String getBookName() {
        return bookName;
    }

    public double getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" + "bookName=" + bookName + ", pages=" + pages + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) && pages == book.pages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, pages);
    }

    @Override
    public int compareTo(Book o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}

class ComparatorBookName implements Comparator<Map.Entry<String, Book>> {

    @Override
    public int compare(Map.Entry<String, Book> book1, Map.Entry<String, Book> book2) {
        return book1.getValue().getBookName().compareToIgnoreCase(book2.getValue().getBookName());
    }

}
