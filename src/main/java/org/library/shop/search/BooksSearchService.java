package org.library.shop.search;


import org.library.shop.cart.AddToCartCriteria;
import org.library.shop.cart.UserCart;
import org.library.shop.model.Book;
import org.library.shop.repository.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksSearchService {


    public SearchResult search(BooksCriteria criteria) {

        List<Book> result = new ArrayList<>();
        Boolean matchIsbn = null;
        Boolean matchName = null;
        Boolean matchAuthor = null;
        List<Book> books = Books.all();
        if(criteria.getName() == null && criteria.getAuthor() ==  null && criteria.getIsbn() == null) {
            return new SearchResult(new ArrayList<>());
        }
        for (Book book : books) {
            if (criteria.getName() != null) {
                String nameCriteria = criteria.getName().toLowerCase();
                matchName = book.getName().toLowerCase().contains(nameCriteria);
            }


            if (criteria.getAuthor() != null) {

                matchAuthor = true;
                for (String s : criteria.getAuthor().toLowerCase().split(" ")) {
                    if (!book.getAuthor().getLastname().toLowerCase().contains(s) && !book.getAuthor().getFirstname().toLowerCase().contains(s)) {
                        matchAuthor = false;
                    }
                }
            }
            String criteriaIsbn = criteria.getIsbn();
            if(criteriaIsbn != null) {
                matchIsbn = book.getIsbn().contains(criteriaIsbn);
            }

            if (matchName != Boolean.FALSE && matchAuthor != Boolean.FALSE && matchIsbn != Boolean.FALSE) {
                result.add(book);
            }
        }
        if(criteria instanceof AddToCartCriteria) {
            UserCart.addToUserCart(result.get(0));
        }
        return new SearchResult(result);
    }
}
