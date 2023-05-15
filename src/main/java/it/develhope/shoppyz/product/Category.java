package it.develhope.shoppyz.product;

import java.util.Random;


public enum Category {

    Elettronica,
    Vestiti,
    Arredamento,
    Pesca,
    Sport;

    private static final Random RNGState = new Random();

    public static Category randomPayment() {
        Category[] categoryTypes = values();
        return categoryTypes[RNGState.nextInt(categoryTypes.length)];

    }
}
