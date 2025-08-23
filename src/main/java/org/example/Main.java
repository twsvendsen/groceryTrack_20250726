package org.example;

import com.tws.grocerytracker.dao.ReceiptDao;
import com.tws.grocerytracker.model.Receipt;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Receipt receipt = new Receipt.Builder().id(1).transactionDateTime(OffsetDateTime.now()).totalCost(new BigDecimal(5)).build();
        ReceiptDao dao = new ReceiptDao();
        dao.catalogueReceipt(receipt);
        System.out.println(receipt.getId());
    }
}