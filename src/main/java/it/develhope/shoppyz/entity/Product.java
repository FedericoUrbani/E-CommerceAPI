package it.develhope.shoppyz.entity;

import java.util.ArrayList;
import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}

