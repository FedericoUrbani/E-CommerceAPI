package it.develhope.shoppyz.product;

import it.develhope.shoppyz.account.PaymentType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Random;

public enum Category {

    Elettronica,
    Vestiti,
    Arredamento,
    Pesca,
    Sport;
}
