package com.tws.grocerytracker.mapper;

import com.tws.grocerytracker.model.Commodity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CommodityMapper {
    public Commodity mapCommodity(String commodityName, String brand, OffsetDateTime timeOfPurchase) {
        Commodity commodity = new Commodity();
        commodity.setName(commodityName);
        commodity.setTimesPurchased(Integer.valueOf("1"));
        commodity.setBrand(brand);
        commodity.setLatestPurchaseDateTime(timeOfPurchase);
        return commodity;
    }
}
