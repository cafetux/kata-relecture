package org.library.shop.cart;

import org.library.shop.model.Book;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    private static ThreadLocal<List<Book>> cart = new ThreadLocal<>();


    public static void addToUserCart(Book book){
        List<Book> bookList = cart.get();
        if(bookList == null) {
            bookList = new ArrayList<>();
        }
        bookList.add(book);
        cart.set(bookList);
    }

}
