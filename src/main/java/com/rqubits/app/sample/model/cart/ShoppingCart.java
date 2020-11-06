package com.rqubits.app.sample.model.cart;

import com.google.common.collect.ImmutableList;
import com.rqubits.app.sample.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart implements Cart {

    private List<Product> products;

    private ShoppingCart() {

    }

    private ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public static ShoppingCart of(List<Product> products) {
        return new ShoppingCart(products);
    }

    @Override
    public List<Product> getProducts() {
        if (Objects.isNull(this.products)) {
            return null;
        }
        return ImmutableList.copyOf(this.products);
    }

    @Override
    public void addProduct(Product product) {
        if (Objects.isNull(getProducts())) {
            this.products = new ArrayList<>();
        }
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + products +
                '}';
    }
}
