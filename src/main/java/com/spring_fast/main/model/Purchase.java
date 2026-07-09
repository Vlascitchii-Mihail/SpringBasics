package com.spring_fast.main.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass())
            return false;

        Purchase purchase = (Purchase) object;
        return id == purchase.id && product.equals(purchase.product)
                && price.equals(purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price);
    }
}
