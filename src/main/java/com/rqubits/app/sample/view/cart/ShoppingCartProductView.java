package com.rqubits.app.sample.view.cart;

import com.rqubits.app.sample.model.product.Product;
import com.rqubits.app.sample.model.product.ProductCode;

import java.util.List;
import java.util.Objects;

public class ShoppingCartProductView {
    private String productName;

    private ProductCode productCode;

    private long quantity;

    private double unitPrice;

    private double total;

    private List<Product> products;

    public ShoppingCartProductView() {

    }

    private ShoppingCartProductView(String productName, ProductCode productCode, long quantity, double unitPrice, double total, List<Product> products) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.products = products;
    }

    public static ShoppingCartProductView from(String productName, ProductCode productCode, long quantity, double unitPrice, double total, List<Product> products) {
        return new ShoppingCartProductView(productName, productCode, quantity, unitPrice, total, products);
    }

    public String getProductName() {
        return productName;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        if (total == 0 && quantity != 0) {
            total = unitPrice * quantity;
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartProductView)) return false;
        ShoppingCartProductView that = (ShoppingCartProductView) o;
        return getProductCode().equals(that.getProductCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductCode());
    }

    @Override
    public String toString() {
        return "ShoppingCartProductView{" +
                "productName='" + productName + '\'' +
                ", productCode=" + productCode +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", products=" + products +
                '}';
    }
}
