package com.rqubits.app.sample.model.product;


import com.rqubits.app.sample.model.category.Category;

import java.util.UUID;

public interface Product {

    UUID getUUID();

    ProductCode getProductCode();

    Category getLevelOneCategory();

    Category getLevelTwoCategory();

    String getName();

    double getCost();

}
