package it.develhope.shoppyz.entity;

import jakarta.persistence.Embeddable;

import java.util.Random;

@Embeddable
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
