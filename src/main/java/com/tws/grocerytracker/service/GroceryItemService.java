package com.tws.grocerytracker.service;

import com.tws.grocerytracker.dto.GroceryItemDto;
import com.tws.grocerytracker.mapper.GroceryItemMapper;
import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import com.tws.grocerytracker.model.Receipt;
import com.tws.grocerytracker.model.StoreLocation;
import com.tws.grocerytracker.repository.GroceryItemRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.tws.grocerytracker.repository.CommodityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GroceryItemService {

    private CommodityService commodityService;
    private CommodityRepository commodityRepository;
    private GroceryItemMapper groceryItemMapper;
    private GroceryItemRepository groceryItemRepository;

    public void buildAndMapGroceryItemList(List<GroceryItemDto> inputGroceryItems, Receipt receipt, StoreLocation storeLocation) {
        List<GroceryItem> groceryItems = new ArrayList<>();
        List<Commodity> existingCommodities = new ArrayList<>();

        if(inputGroceryItems == null || inputGroceryItems.isEmpty()) {
            // throw exception?
            return;
        }

        existingCommodities = commodityRepository.findAllByNameOfProductIn(inputGroceryItems);

        // build and save groceryItems
        for(GroceryItemDto inputGroceryItem : inputGroceryItems) {

            // find and map commodity types
            Commodity matchedCommodity = existingCommodities.stream()
                    .filter(commodity ->
                            StringUtils.isNotEmpty(commodity.getName())
                                    && StringUtils.isNotEmpty(inputGroceryItem.getNameOfProduct())
                                    && commodity.getName().equalsIgnoreCase(inputGroceryItem.getNameOfProduct()))
                    .findFirst().orElse(
                            // create and save new commodity
                            commodityService.createNewCommodity(inputGroceryItem.getNameOfProduct(), receipt.getTransactionDateTime()));

            // create groceryItem
            GroceryItem groceryItem = createNewGroceryItem(inputGroceryItem, receipt, storeLocation, matchedCommodity);
            groceryItems.add(groceryItem);
        }

        commodityService.updateCommodities(existingCommodities, receipt.getTransactionDateTime());
        receipt.setGroceryItems(groceryItems);
        groceryItemRepository.saveAll(groceryItems);
    }

    private GroceryItem createNewGroceryItem(GroceryItemDto inputGroceryItem, Receipt receipt, StoreLocation storeLocation, Commodity matchedCommodity) {
        GroceryItem groceryItem = groceryItemMapper.mapGroceryItemDtoToGroceryItem(inputGroceryItem, receipt, storeLocation, matchedCommodity);
        groceryItemRepository.save(groceryItem);
        return groceryItem;
    }
}
