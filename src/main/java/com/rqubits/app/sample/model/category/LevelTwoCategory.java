package com.rqubits.app.sample.model.category;

public class LevelTwoCategory implements Category {

    private CategoryType type;

    private Category parentCategory;

    private LevelTwoCategory() {

    }

    private LevelTwoCategory(CategoryType type, Category parentCategory) {
        this.type = type;
        this.parentCategory = parentCategory;
    }

    public static LevelTwoCategory of(CategoryType type, Category parentCategory) {
        return new LevelTwoCategory(type, parentCategory);
    }

    public CategoryType getType() {
        return type;
    }

    @Override
    public Category getParentCategory() {
        return parentCategory;
    }

    @Override
    public String toString() {
        return "LevelTwoCategory{" +
                "type=" + type +
                ", parentCategory=" + parentCategory +
                '}';
    }
}
