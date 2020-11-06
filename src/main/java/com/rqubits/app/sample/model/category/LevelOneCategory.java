package com.rqubits.app.sample.model.category;

public class LevelOneCategory implements Category {

    private CategoryType type;

    private LevelOneCategory() {

    }

    private LevelOneCategory(CategoryType type) {
        this.type = type;
    }

    public static LevelOneCategory of(CategoryType type) {
        return new LevelOneCategory(type);
    }

    public CategoryType getType() {
        return type;
    }

    @Override
    public Category getParentCategory() {
        return null;
    }

    @Override
    public String toString() {
        return "LevelOneCategory{" +
                "type=" + type +
                '}';
    }
}
