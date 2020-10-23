package org.library.shop.cart;

import org.library.shop.search.BooksCriteria;

public class AddToCartCriteria extends BooksCriteria {


    @Override
    public void setAuthor(String author) {
        throw new IllegalArgumentException("add to cart only by ISBN");
    }

    @Override
    public void setName(String name) {
        throw new IllegalArgumentException("add to cart only by ISBN");
    }


}
