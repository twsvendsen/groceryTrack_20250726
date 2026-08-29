package org.example;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.dto.ReceiptDto;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.ItemCategory;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.service.ReceiptService;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("main thread initiating");

//        Commodity testCommodity = new Commodity();
//        testCommodity.setId(1);
//        testCommodity.setBrand("testBrand");
//        testCommodity.setItemCategory(ItemCategory.OTHER);
//        testCommodity.setItemName("testItemName");
//        testCommodity.setTimesPurchased(0);
//        testCommodity.setTimeOfLatestPurchase(OffsetDateTime.now());
//
//        List<GroceryItem> groceryItems = new ArrayList<>();
//        groceryItems.add(new GroceryItem.Builder().uniqueId(1).commodity(testCommodity).build());
//        Receipt receipt = new Receipt.Builder().id(1).transactionDateTime(OffsetDateTime.now()).groceryItems(groceryItems).totalCost(new BigDecimal(5)).build();

        GroceryItemDto groceryItemDto = new GroceryItemDto();
        groceryItemDto.setNameOfProduct("Kleenex tissues");
        groceryItemDto.setCost(new BigDecimal("19.99"));

        ReceiptDto receiptDto = new ReceiptDto();
        receiptDto.setGroceryItems(List.of(groceryItemDto));
        receiptDto.setTransactionDateTime(OffsetDateTime.now().toString());
        receiptDto.setAddress("123 Fake Street");
        receiptDto.setStoreName("Babblemart");
        receiptDto.setTotalCost(new BigDecimal("21.78"));

//        ReceiptService receiptService = new ReceiptService();
//        receiptService.createReceipt(receiptDto);
//
//        System.out.println("main thread concluding");
    }
}