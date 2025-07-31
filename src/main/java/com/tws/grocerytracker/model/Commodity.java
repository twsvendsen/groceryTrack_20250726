package com.tws.grocerytracker.model;

import lombok.Data;

@Data
public class Commodity {
    String itemName;
    String brand;
    Integer timesPurchased;
}
