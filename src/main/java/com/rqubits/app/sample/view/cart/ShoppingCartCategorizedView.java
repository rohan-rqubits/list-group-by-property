package com.rqubits.app.sample.view.cart;

import com.rqubits.app.sample.model.category.Category;

import java.util.List;

public class ShoppingCartCategorizedView {
    private String productName;

    private Category category;

    private long quantity;

    private double total;

    private List<ShoppingCartProductView> productView;

    private ShoppingCartCategorizedView() {

    }

    private ShoppingCartCategorizedView(String productName, Category category, long quantity, double total, List<ShoppingCartProductView> productView) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.total = total;
        this.productView = productView;
    }

    public static ShoppingCartCategorizedView from(String productName, Category category, long quantity, double total, List<ShoppingCartProductView> productView) {
        return new ShoppingCartCategorizedView(productName, category, quantity, total, productView);
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public List<ShoppingCartProductView> getProductView() {
        return productView;
    }

    @Override
    public String toString() {
        return "ShoppingCartCategorizedView{" +
                "productName='" + productName + '\'' +
                ", category=" + category +
                ", quantity=" + quantity +
                ", total=" + total +
                ", products=" + productView +
                '}';
    }
}
