package edu.rafael.collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
 * Given the following informations about my favorite TV shows, create a set and sort it like:
 * (name, genre, episodeDuration)
 * 
 * 1 TV Show = Name: got, Genre: fantasy, episodeDuration: 60;
 * 2 TV Show = Name: dark, Genre: drama, episodeDuration: 60;
 * 3 TV Show = Name: that '70s show, Genre: comedy, episodeDuration: 25;
 * 
 */
public class SetSorting {
    public static void main(String[] args) {

        System.out.println("--\tRandom Order\t---");
        Set<Show> tvShows = new HashSet<>() {
            {
                add(new Show("got", "fantasy", 60));
                add(new Show("dark", "drama", 60));
                add(new Show("that 70's show", "comedy", 25));
            }
        };
        for (Show show : tvShows) {
            System.out.println(show.getName() + " - " + show.getGenre() + " - " + show.getEpisodeDuration());
            ;
        }
        System.out.println("--\tInput Order\t---");
        Set<Show> tvShows1 = new LinkedHashSet<>() {
            {
                add(new Show("got", "fantasy", 60));
                add(new Show("dark", "drama", 60));
                add(new Show("that 70's show", "comedy", 25));
            }
        };
        for (Show show : tvShows1) {
            System.out.println(show.getName() + " - " + show.getGenre() + " - " + show.getEpisodeDuration());
            ;
        }

        System.out.println("--\tSort by Episode Duration\t---");
        Set<Show> tvShows2 = new TreeSet<>(tvShows1);
        for (Show show : tvShows2) {
            System.out.println(show.getName() + " - " + show.getGenre() + " - " + show.getEpisodeDuration());
            ;
        }

        System.out.println("--\tSort by Name/Genre/EpisodeDuration\t---");
        Set<Show> tvShows3 = new TreeSet<>(new ComparateNameGenreEpisodeDuration());
        tvShows3.addAll(tvShows);
        for (Show show : tvShows3) {
            System.out.println(show.getName() + " - " + show.getGenre() + " - " + show.getEpisodeDuration());
            ;
        }
    }

}

class Show implements Comparable<Show> {
    private String name;
    private String genre;
    private int episodeDuration;

    public Show(String name, String genre, int episodeDuration) {
        this.name = name;
        this.genre = genre;
        this.episodeDuration = episodeDuration;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getEpisodeDuration() {
        return episodeDuration;
    }

    @Override
    public String toString() {
        return "Show{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", episodeDuration=" + episodeDuration +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Show)) {
            return false;
        }
        Show show = (Show) o;
        return Objects.equals(name, show.name) && Objects.equals(genre, show.genre)
                && episodeDuration == show.episodeDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, episodeDuration);
    }

    @Override
    public int compareTo(Show show) {
        int episodeDuration = Integer.compare(this.getEpisodeDuration(), show.getEpisodeDuration());
        if (episodeDuration != 0) {
            return episodeDuration;
        }
        return this.getGenre().compareTo(show.getGenre());

    }
}

class ComparateNameGenreEpisodeDuration implements Comparator<Show> {
    @Override
    public int compare(Show show1, Show show2) {
        int name = show1.getName().compareTo(show2.getName());
        if (name != 0) {
            return name;
        }
        int genre = show1.getGenre().compareTo(show2.getGenre());
        if (genre != 0) {
            return genre;
        }
        return Integer.compare(show1.getEpisodeDuration(), show2.getEpisodeDuration());
    }
}
