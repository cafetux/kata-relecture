package org.library.shop.model;

import java.util.Objects;

public class Price {

    private final long cents;

    private Price(long cents) {
        this.cents = cents;
    }

    public static Price fromCents(long cents) {
        return new Price(cents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return cents == price.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }

    @Override
    public String toString() {
        return "Price{" +
                "cents=" + cents +
                '}';
    }
}
