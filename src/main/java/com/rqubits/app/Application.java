package com.rqubits.app;

import com.rqubits.app.sample.model.cart.Cart;
import com.rqubits.app.sample.model.cart.ShoppingCart;
import com.rqubits.app.sample.model.category.*;
import com.rqubits.app.sample.model.product.Product;
import com.rqubits.app.sample.model.product.ProductCode;
import com.rqubits.app.sample.model.product.SellableProduct;
import com.rqubits.app.sample.view.cart.ShoppingCartCategorizedView;
import com.rqubits.app.sample.view.cart.ShoppingCartProductView;
import com.rqubits.app.util.ListUtil;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        Cart cart = createMockCartData();
        System.out.println(cart.getProducts().size());

        Set<ProductCode> productCodes = cart.getProducts().stream().map(product -> product.getProductCode()).collect(Collectors.toSet());

        List<ShoppingCartProductView> shoppingCartProductView = productCodes.stream().map(productCode -> {

            List<Product> productCodeFiltered = ListUtil.findByProperty(cart.getProducts(), product -> product.getProductCode() == productCode);
            Product product = productCodeFiltered.stream().findAny().get();
            return ShoppingCartProductView.from(product.getName(),
                    product.getProductCode(),
                    productCodeFiltered.size(),
                    product.getCost(),
                    0, productCodeFiltered);
        }).collect(Collectors.toList());

        Set<Category> categories = cart.getProducts().stream().map(product -> product.getLevelOneCategory()).collect(Collectors.toSet());

        List<ShoppingCartCategorizedView> shoppingCartCategorizedView = categories.stream().map(category -> {
            List<Product> categoryFiltered = ListUtil.findByProperty(cart.getProducts(), product -> product.getLevelOneCategory() == category);
            List<ShoppingCartProductView> viewFiltered = ListUtil.findByProperty(shoppingCartProductView, view -> view.getProductCode().getLevelOneCategory() == category);
            Product product = categoryFiltered.stream().findAny().get();
            return ShoppingCartCategorizedView.from(product.getName(),
                    product.getLevelOneCategory(),
                    categoryFiltered.size(),
                    categoryFiltered.stream().mapToDouble(p -> p.getCost()).reduce((cost1, cost2) -> cost1 + cost2).getAsDouble(),
                    viewFiltered);
        }).collect(Collectors.toList());


        printCategorizedView(shoppingCartCategorizedView);

    }

    private static void printCategorizedView(List<ShoppingCartCategorizedView> shoppingCartCategorizedView) {
        for (ShoppingCartCategorizedView cartCategorizedView : shoppingCartCategorizedView) {
            System.out.println("\nCategory : " + cartCategorizedView.getCategory().getType().getLabel());
            printProductView(cartCategorizedView.getProductView());
            System.out.println("Sub Total : " + cartCategorizedView.getTotal());
        }
    }

    private static void printProductView(List<ShoppingCartProductView> productView) {
        productView.forEach(view -> {
            System.out.println("Item: " + view.getProductName() +
                    "\tUnits: " + view.getQuantity() +
                    "\tUnit Price: " + view.getUnitPrice() +
                    "\tAmount: " + view.getTotal()
            );
        });
    }


    private static Cart createMockCartData() {
        Cart cart = ShoppingCart.of(null);

        Category veggiesCategory = LevelOneCategory.of(LevelOneCategoryType.VEGGIES);
        Category onionCategory = LevelTwoCategory.of(LevelTwoCategoryType.ONION, veggiesCategory);
        Category tomatoCategory = LevelTwoCategory.of(LevelTwoCategoryType.TOMATO, veggiesCategory);

        Category dairyCategory = LevelOneCategory.of(LevelOneCategoryType.DAIRY);
        Category milkCategory = LevelTwoCategory.of(LevelTwoCategoryType.MILK, dairyCategory);

        Category snacksCategory = LevelOneCategory.of(LevelOneCategoryType.SNACKS);
        Category biscuitCategory = LevelTwoCategory.of(LevelTwoCategoryType.BISCUIT, snacksCategory);
        Category chipsCategory = LevelTwoCategory.of(LevelTwoCategoryType.CHIPS, snacksCategory);
        Category chocolateCategory = LevelTwoCategory.of(LevelTwoCategoryType.CHOCOLATE, snacksCategory);


        Product onions = SellableProduct.from(UUID.randomUUID(), "Onions", 100, veggiesCategory, onionCategory, ProductCode.from(veggiesCategory, onionCategory, "ONIONS"));
        addProductWithQuantity(cart, onions, 2);
        Product tomatoes = SellableProduct.from(UUID.randomUUID(), "Tomatoes", 60, veggiesCategory, tomatoCategory, ProductCode.from(veggiesCategory, tomatoCategory, "TOMATOES"));
        addProductWithQuantity(cart, tomatoes, 1);
        Product milk = SellableProduct.from(UUID.randomUUID(), "Milk", 60, dairyCategory, milkCategory, ProductCode.from(dairyCategory, milkCategory, "MILK"));
        addProductWithQuantity(cart, milk, 4);
        Product biscuits = SellableProduct.from(UUID.randomUUID(), "Biscuits", 20, snacksCategory, biscuitCategory, ProductCode.from(snacksCategory, biscuitCategory, "BISCUITS"));
        addProductWithQuantity(cart, biscuits, 2);
        Product chips = SellableProduct.from(UUID.randomUUID(), "Chips", 40, snacksCategory, chipsCategory, ProductCode.from(snacksCategory, chipsCategory, "CHIPS"));
        addProductWithQuantity(cart, chips, 3);
        Product chocolate = SellableProduct.from(UUID.randomUUID(), "Chocolate", 50, snacksCategory, chocolateCategory, ProductCode.from(snacksCategory, chocolateCategory, "CHOCOLATE"));
        addProductWithQuantity(cart, chocolate, 1);

        return cart;
    }

    private static void addProductWithQuantity(Cart cart, Product baseProduct, int quantity) {
        IntStream.range(0, quantity).forEach(i -> {
            cart.addProduct(SellableProduct.from(UUID.randomUUID(), baseProduct.getName(), baseProduct.getCost(), baseProduct.getLevelOneCategory(), baseProduct.getLevelTwoCategory(), baseProduct.getProductCode()));
        });
    }
}
