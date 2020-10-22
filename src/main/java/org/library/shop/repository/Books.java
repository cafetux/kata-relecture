package org.library.shop.repository;

import org.library.shop.model.Author;
import org.library.shop.model.Book;
import org.library.shop.model.Price;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("2070729680","Surveiller et punir",new Author("michel","foucault"), Price.fromCents(1400)));
        books.add(new Book("5321729680","Dans la disruption: Comment ne pas devenir fou ?",new Author("bernard","stiegler"), Price.fromCents(1499)));
        books.add(new Book("2962070780","il faut s'adapter",new Author("barbara","stiegler"), Price.fromCents(2200)));
        books.add(new Book("4560729765","le petit prince",new Author("antoine","de Saint-Exupéry"), Price.fromCents(700)));
        books.add(new Book("7532729643","Spring Boot in Action",new Author("Craig","Walls"), Price.fromCents(2438)));
        books.add(new Book("5357853246","effective java",new Author("Joshua","Bloch"), Price.fromCents(2953)));
        books.add(new Book("4677674553","La Zone du Dehors",new Author("alain","damasio"), Price.fromCents(1150)));
    }

    public static List<Book> all() {
        return new ArrayList<>(books);
    }

}
