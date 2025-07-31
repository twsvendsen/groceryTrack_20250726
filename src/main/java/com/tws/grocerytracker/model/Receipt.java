package com.tws.grocerytracker.model;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {

    List<GroceryItem> groceryItems;
    Double totalCost;
}
