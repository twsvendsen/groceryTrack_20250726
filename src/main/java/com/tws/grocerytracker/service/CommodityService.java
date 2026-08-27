package com.tws.grocerytracker.service;

import com.tws.grocerytracker.mapper.CommodityMapper;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.repository.CommodityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommodityService {

    private CommodityMapper commodityMapper;
    private CommodityRepository commodityRepository;

    public Commodity createNewCommodity(String productName, OffsetDateTime timeOfPurchase) {
        // TODO: validate receipt was scanned correctly
        String commodityName = extractCommodityName(productName);
        String brandName = extractBrandName(productName);
        Commodity commodity = commodityMapper.mapCommodity(commodityName, brandName, timeOfPurchase);
        commodityRepository.save(commodity);
        return commodity;
    }

    public void updateCommodities(List<Commodity> commodities, OffsetDateTime transactionDateTime) {
        for(Commodity commodity : commodities) {
            commodity.setLatestPurchaseDateTime(transactionDateTime);
            commodity.setTimesPurchased(commodity.getTimesPurchased() + 1);
        }
    }

    private String extractCommodityName(String productName) {
        return "Todo";
    }

    private String extractBrandName(String productName) {
        return "Todo";
    }
}
