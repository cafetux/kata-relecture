package org.library.shop.search;

import org.library.shop.model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    private final List<Book> results;

    public SearchResult(List<Book> results) {
        this.results = results;
    }

    public boolean isEmpty() {
        return results.isEmpty();
    }

    public List<Book> get() {
        return new ArrayList<>(results);
    }
}
