package com.rqubits.app.sample.model.product;

import com.rqubits.app.sample.model.category.Category;

import java.util.UUID;

public class SellableProduct implements Product {
    private UUID uuid;

    private String name;

    private double cost;

    private Category levelOneCategory;

    private Category levelTwoCategory;

    private ProductCode productCode;

    private SellableProduct() {

    }

    private SellableProduct(UUID uuid, String name, double cost, Category levelOneCategory, ProductCode productCode) {
        this.uuid = uuid;
        this.name = name;
        this.cost = cost;
        this.levelOneCategory = levelOneCategory;
        this.productCode = productCode;
    }

    private SellableProduct(UUID uuid, String name, double cost, Category levelOneCategory, Category levelTwoCategory, ProductCode productCode) {
        this.uuid = uuid;
        this.name = name;
        this.cost = cost;
        this.levelOneCategory = levelOneCategory;
        this.levelTwoCategory = levelTwoCategory;
        this.productCode = productCode;
    }

    public static SellableProduct from(UUID uuid, String name, double cost, Category levelOneCategory, ProductCode productCode) {
        return new SellableProduct(uuid, name, cost, levelOneCategory, productCode);
    }

    public static SellableProduct from(UUID uuid, String name, double cost, Category levelOneCategory, Category levelTwoCategory, ProductCode productCode) {
        return new SellableProduct(uuid, name, cost, levelOneCategory, levelTwoCategory, productCode);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public ProductCode getProductCode() {
        return productCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public Category getLevelOneCategory() {
        return levelOneCategory;
    }

    public Category getLevelTwoCategory() {
        return levelTwoCategory;
    }


}
