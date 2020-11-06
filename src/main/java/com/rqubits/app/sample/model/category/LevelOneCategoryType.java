package com.rqubits.app.sample.model.category;

public enum LevelOneCategoryType implements CategoryType {
    VEGGIES("Veggies"),
    DAIRY("Dairy"),
    SNACKS("Snacks");

    private String label;

    LevelOneCategoryType(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
