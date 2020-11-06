package com.rqubits.app.sample.model.cart;

import com.rqubits.app.sample.model.product.Product;

import java.util.List;

public interface Cart {
    List<Product> getProducts();

    void addProduct(Product product);
}
