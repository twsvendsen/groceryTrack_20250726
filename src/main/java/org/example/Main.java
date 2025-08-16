package org.example;

import com.tws.grocerytracker.model.Receipt;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Receipt receipt = new Receipt.Builder().id(1).dateTime(OffsetDateTime.now()).totalCost(new BigDecimal(5)).build();

        System.out.println(receipt.getId());
    }
}