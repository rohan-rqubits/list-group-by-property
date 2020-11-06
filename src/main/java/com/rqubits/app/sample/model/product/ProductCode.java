package com.rqubits.app.sample.model.product;

import com.rqubits.app.sample.model.category.Category;

import java.util.Objects;

public class ProductCode {

    private Category levelOneCategory;

    private Category levelTwoCategory;

    private String code;

    private ProductCode() {

    }

    private ProductCode(Category levelOneCategory, Category levelTwoCategory, String code) {
        this.levelOneCategory = levelOneCategory;
        this.levelTwoCategory = levelTwoCategory;
        this.code = code;
    }

    public static ProductCode from(Category levelOneCategory, Category levelTwoCategory, String code) {
        return new ProductCode(levelOneCategory, levelTwoCategory, code);
    }

    public Category getLevelOneCategory() {
        return levelOneCategory;
    }

    public Category getLevelTwoCategory() {
        return levelTwoCategory;
    }

    private String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCode)) return false;
        ProductCode that = (ProductCode) o;
        return getLevelOneCategory().equals(that.getLevelOneCategory()) &&
                getLevelTwoCategory().equals(that.getLevelTwoCategory()) &&
                getCode().equals(that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLevelOneCategory(), getLevelTwoCategory(), getCode());
    }

    @Override
    public String toString() {
        return "ProductCode{" +
                "levelOneCategory=" + levelOneCategory +
                ", levelTwoCategory=" + levelTwoCategory +
                ", code='" + code + '\'' +
                '}';
    }
}
