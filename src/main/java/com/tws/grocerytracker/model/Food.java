package com.tws.grocerytracker.model;

import jakarta.persistence.Entity;

@Entity
public class Food extends Commodity {

    private String flavor;
}
