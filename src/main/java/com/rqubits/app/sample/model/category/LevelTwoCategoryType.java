package com.rqubits.app.sample.model.category;

public enum LevelTwoCategoryType implements CategoryType {
    MILK("Milk"),
    ONION("Onion"),
    TOMATO("Tomato"),
    BISCUIT("Biscuit"),
    CHIPS("Chip"),
    CHOCOLATE("Chocolate");

    private String label;

    LevelTwoCategoryType(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
